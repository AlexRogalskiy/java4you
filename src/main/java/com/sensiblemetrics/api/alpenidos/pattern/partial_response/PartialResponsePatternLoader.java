package com.sensiblemetrics.api.alpenidos.pattern.partial_response;

import com.sensiblemetrics.api.alpenidos.pattern.partial_response.mapper.FieldJsonMapper;
import com.sensiblemetrics.api.alpenidos.pattern.partial_response.model.Video;
import com.sensiblemetrics.api.alpenidos.pattern.partial_response.server.VideoResource;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * The Partial response pattern is a design pattern in which client specifies fields to fetch to serve.
 * Here {@link PartialResponsePatternLoader} is playing as client for {@link VideoResource} server.
 * SimpleFactoryPatternLoader ask for specific fields information in video to server.
 * <p>
 * <p>
 * {@link VideoResource} act as server to serve video information.
 */
@Slf4j
public class PartialResponsePatternLoader {

    /**
     * Method as act client and request to server for video details.
     *
     * @param args program argument.
     */
    public static void main(final String[] args) throws Exception {
        final Map<Integer, Video> videos = new HashMap<>();
        videos.put(1, new Video(1, "Avatar", 178, "epic science fiction film", "James Cameron", "English"));
        videos.put(2, new Video(2, "Godzilla Resurgence", 120, "Action & drama movie|", "Hideaki Anno", "Japanese"));
        videos.put(3, new Video(3, "Interstellar", 169, "Adventure & Sci-Fi", "Christopher Nolan", "English"));
        final VideoResource videoResource = new VideoResource(new FieldJsonMapper(), videos);


        log.info("Retrieving full response from server:-");
        log.info("Get all video information:");
        final String videoDetails = videoResource.getDetails(1);
        log.info(videoDetails);

        log.info("----------------------------------------------------------");

        log.info("Retrieving partial response from server:-");
        log.info("Get video @id, @title, @director:");
        final String specificFieldsDetails = videoResource.getDetails(3, "id", "title", "director");
        log.info(specificFieldsDetails);

        log.info("Get video @id, @length:");
        final String videoLength = videoResource.getDetails(3, "id", "length");
        log.info(videoLength);
    }
}
