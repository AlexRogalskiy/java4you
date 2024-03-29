package com.sensiblemetrics.api.alpenidos.pattern.spring_boot2.service;

import com.sensiblemetrics.api.alpenidos.pattern.spring_boot2.config.ConfigParams;
import com.sensiblemetrics.api.alpenidos.pattern.spring_boot2.dao.FollowedRepository;
import com.sensiblemetrics.api.alpenidos.pattern.spring_boot2.model.Followed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class FollowService {
    private double waitBetweenFollowsSeconds = 1;
    private double waitBetweenUnfollowsSeconds = 0.1;
    private String TWITTER_API_URL = "https://api.twitter.com/1.1";
    private String X_CSRF_TOKEN_HEADER = "x-csrf-token";

    private int followerCount = 200;

    private final FollowedRepository followedRepository;
    private final FollowingAmountService followingAmountService;
    private final MailingService mailingService;
    private final ConfigParams configParams;

    public int add(final int a, final int b) {
        return a + b;
    }

    public void execute() throws Exception {
        long[] followers = getImFollowingAndMyFollowers();
        long imFollowing = followers[0];
        long myFollowers = followers[1];

        if (followers[0] >= 3500) {
            // Do unfollows
            // Do follows
            log.info("Do unfollows first");
            doUnfollows();
            doFollows();
        } else {
            // Do follows
            log.info("Do follows first");
            doFollows();
        }

        // Update followers
        followers = getImFollowingAndMyFollowers();
        imFollowing = followers[0];
        myFollowers = followers[1];

        if (imFollowing == 0) {
            log.info("Account blocked with recaptcha, notify");
            mailingService.notifyRecaptchaBlock();
        }
        followingAmountService.saveFollowingAmounts(imFollowing, myFollowers);
        log.info("Finished, done for today");
    }

    private void doUnfollows() throws Exception {
        HttpResponse response = Request.Get(
            String.format("%s/friends/list.json?user_id=%s&count=%s", TWITTER_API_URL, configParams.getHomeAccountId(), followerCount))
            .addHeader(HttpHeaders.AUTHORIZATION, configParams.getAuthorizationBearerToken())
            .execute()
            .returnResponse();

        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            log.error("Failed fetching home followers: '%s'", configParams.getHomeAccountId());
            return;
        }
        HttpEntity entity = response.getEntity();
        JSONObject json = new JSONObject(EntityUtils.toString(entity, "UTF-8"));

        final JSONArray users = json.getJSONArray("users");
        for (int i = 0; i < users.length(); i++) {
            JSONObject user = (JSONObject) users.get(i);

            long id = user.getLong("id");
            String name = user.getString("name");
            String screenName = user.getString("screen_name");

            Followed followed = followedRepository.findByExternalId(String.valueOf(id));
            boolean shouldUnfollow = shouldUnfollow(followed);
            if (!shouldUnfollow) {
                log.info(String.format("Shouldn't unfollow '%s' yet", screenName));
                continue;
            }

            String cookie = String.format("auth_token=%s; ct0=%s;", configParams.getAuthToken(), configParams.getCsrfToken());

            response = Request.Post(TWITTER_API_URL + "/friendships/destroy.json")
                .addHeader(HttpHeaders.AUTHORIZATION, configParams.getAuthorizationBearerToken())
                .addHeader(X_CSRF_TOKEN_HEADER, configParams.getCsrfToken())
                .addHeader("cookie", cookie)
                .bodyForm(
                    Form.form()
                        .add("id", String.valueOf(id))
                        .build())
                .execute()
                .returnResponse();

            statusCode = response.getStatusLine().getStatusCode();
            entity = response.getEntity();
            json = new JSONObject(EntityUtils.toString(entity, "UTF-8"));
            if (statusCode != 200) {
                log.error(String.format("Couldn't execute: %s, got statusCode: %s, response: %s", name, statusCode, json));
                break;
            }

            log.info(String.format("Unfollowed '%s' successfully", name));

            Thread.sleep((long) (waitBetweenUnfollowsSeconds * 1000.0));
        }

    }

    private void doFollows() throws Exception {
        List<String> accounts = configParams.getAccountsToFollow();
        Random random = new Random();
        String account = accounts.get(random.nextInt(accounts.size()));
        log.info(String.format("Start following '%s'", account));

        HttpResponse response = Request.Get(
            String.format("%s/users/show.json?screen_name=%s", TWITTER_API_URL, account))
            .addHeader(HttpHeaders.AUTHORIZATION, configParams.getAuthorizationBearerToken())
            .execute()
            .returnResponse();
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            log.error("Failed fetching account: '%s'", account);
            return;
        }
        HttpEntity entity = response.getEntity();
        JSONObject json = new JSONObject(EntityUtils.toString(entity, "UTF-8"));

        long userId = json.getLong("id");

        response = Request.Get(
            String.format("%s/followers/list.json?cursor=-1&user_id=%s&count=%s", TWITTER_API_URL, userId, followerCount))
            .addHeader(HttpHeaders.AUTHORIZATION, configParams.getAuthorizationBearerToken())
            .execute()
            .returnResponse();

        statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            log.error("Failed fetching followers: '%s'", account);
            return;
        }

        entity = response.getEntity();
        json = new JSONObject(EntityUtils.toString(entity, "UTF-8"));

        JSONArray users = json.getJSONArray("users");

        String cookie = String.format("auth_token=%s; ct0=%s;", configParams.getAuthToken(), configParams.getCsrfToken());

        for (int i = 0; i < users.length(); i++) {
            JSONObject user = (JSONObject) users.get(i);

            long id = user.getLong("id");
            String name = user.getString("name");
            String screenName = user.getString("screen_name");
            Object followingObj = user.get("following");
            Boolean following = (JSONObject.NULL.equals(followingObj) ? false : (Boolean) followingObj);

            // Check if already following
            if (following) {
                log.info(String.format("Already followed '%s', skip", screenName));
                continue;
            }

            // Validate if real user
            final String description = user.getString("description");
            if (description == null || description.trim().isEmpty()) {
                log.info(String.format("Skip '%s', probably a bot", screenName));
                continue;
            }

            Followed followed = followedRepository.findByExternalId(String.valueOf(id));
            if (followed != null) {
                log.info("Have already followed " + followed.getExternalName() + ", skip");
                continue;
            }

            response = Request.Post(TWITTER_API_URL + "/friendships/create.json")
                .addHeader(HttpHeaders.AUTHORIZATION, configParams.getAuthorizationBearerToken())
                .addHeader(X_CSRF_TOKEN_HEADER, configParams.getCsrfToken())
                .addHeader("cookie", cookie)
                .bodyForm(
                    Form.form()
                        .add("id", String.valueOf(id))
                        .build())
                .execute()
                .returnResponse();

            statusCode = response.getStatusLine().getStatusCode();
            entity = response.getEntity();
            json = new JSONObject(EntityUtils.toString(entity, "UTF-8"));
            if (statusCode != 200) {
                log.error(String.format("Couldn't execute: %s, got statusCode: %s, response: %s", name, statusCode, json));
                break;
            }

            followed = new Followed(screenName, String.valueOf(userId));
            followedRepository.save(followed);

            log.info(String.format("Followed '%s' successfully", name));

            Thread.sleep((long) (waitBetweenFollowsSeconds * 1000.0));
        }

    }

    private long[] getImFollowingAndMyFollowers() throws Exception {
        long[] followers = new long[2];

        String homeUrl = String.format("https://twitter.com/%s", configParams.getHomeAccountName());

        HttpResponse response = Request.Get(homeUrl)
            .execute()
            .returnResponse();

        String html = EntityUtils.toString(response.getEntity(), "UTF-8");

        Document parsed = Jsoup.parse(html);

        Elements imFollowingElements = parsed.select("a.ProfileNav-stat[data-nav=\"following\"]");
        Elements myFollowersElements = parsed.select("a.ProfileNav-stat[data-nav=\"followers\"]");

        long imFollowing = 0;
        long myFollowers = 0;

        if (imFollowingElements.size() > 0) {
            Element valueElement = imFollowingElements.get(0).select("span.ProfileNav-value").get(0);
            String imFollowingStr = valueElement.attr("data-count");
            imFollowing = Long.parseLong(imFollowingStr);
        }

        if (myFollowersElements.size() > 0) {
            Element valueElement = myFollowersElements.get(0).select("span.ProfileNav-value").get(0);
            String myFollowersStr = valueElement.attr("data-count");
            myFollowers = Long.parseLong(myFollowersStr);
        }

        followers[0] = imFollowing;
        followers[1] = myFollowers;

        return followers;
    }

    private boolean shouldUnfollow(Followed followed) {
        if (followed != null) {
            Instant followedDate = followed.getFollowed();
            Instant now = Instant.now();
            Duration duration = Duration.between(followedDate, now);
            if (Math.abs(duration.toHours()) >= 48) {
                log.info("Have followed at least 2 days, remove");
                return true;
            } else {
                return false;
            }
        } else {
            // Nothing in DB, so remove it
            return true;
        }
    }
}
