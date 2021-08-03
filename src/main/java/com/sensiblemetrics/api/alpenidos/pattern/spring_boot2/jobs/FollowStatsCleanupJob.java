package com.sensiblemetrics.api.alpenidos.pattern.spring_boot2.jobs;

import com.sensiblemetrics.api.alpenidos.pattern.spring_boot2.model.FollowingAmount;
import com.sensiblemetrics.api.alpenidos.pattern.spring_boot2.service.FollowingAmountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Slf4j
@Component
public class FollowStatsCleanupJob {
    private final FollowingAmountService followingAmountService;
    private DateTimeFormatter formatter;

    @Autowired
    public FollowStatsCleanupJob(FollowingAmountService followingAmountService) {
        this.followingAmountService = followingAmountService;
        formatter = DateTimeFormatter.ofPattern("dd-MM")
            .withLocale(Locale.UK)
            .withZone(ZoneId.systemDefault());
    }

    @Scheduled(cron = "0 55 23 * * ?") // 23:55
    public void cleanup() {
        log.info("Clean up older than 30 days first");

        Instant then = Instant.now().minusSeconds(2592000); // 30 days ago
        List<FollowingAmount> followingAmounts = followingAmountService.findByCreatedLessThanOrderByCreatedAsc(then);
        log.info("Found 30 days older: " + followingAmounts.size());
        for (FollowingAmount followingAmount : followingAmounts) {
            this.followingAmountService.delete(followingAmount);
        }

        followingAmounts = this.followingAmountService.findByCreatedGreaterThanOrderByCreatedAsc(then);

        log.info("Clean up newer than 30 days leaving only last entry per day");
        log.info("Found newer than 30 days: " + followingAmounts.size());
        for (int i = 0; i < followingAmounts.size(); i++) {
            FollowingAmount current = followingAmounts.get(i);
            if (followingAmounts.size() > i + 1) {
                FollowingAmount next = followingAmounts.get(i + 1);
                String currentDate = formatter.format(current.getCreated());
                String nextDate = formatter.format(next.getCreated());
                if (currentDate.equals(nextDate)) {
                    log.info("Deleting: " + currentDate);
                    followingAmountService.delete(current);
                } else {
                    log.info("Skipping: " + currentDate);
                }
            }
        }
    }

}
