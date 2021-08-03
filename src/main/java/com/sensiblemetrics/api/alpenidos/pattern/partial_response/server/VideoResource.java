package com.sensiblemetrics.api.alpenidos.pattern.partial_response.server;

import com.sensiblemetrics.api.alpenidos.pattern.partial_response.mapper.FieldJsonMapper;
import com.sensiblemetrics.api.alpenidos.pattern.partial_response.model.Video;

import java.util.Map;

/**
 * The resource class which serves video information.
 * This class act as server in the demo. Which has all video details.
 */
public class VideoResource {
    private FieldJsonMapper fieldJsonMapper;
    private Map<Integer, Video> videos;

    /**
     * @param fieldJsonMapper map object to json.
     * @param videos          initialize resource with existing videos. Act as database.
     */
    public VideoResource(final FieldJsonMapper fieldJsonMapper, final Map<Integer, Video> videos) {
        this.fieldJsonMapper = fieldJsonMapper;
        this.videos = videos;
    }

    /**
     * @param id     video id
     * @param fields fields to get information about
     * @return full response if no fields specified else partial response for given field.
     */
    public String getDetails(final Integer id, final String... fields) throws Exception {
        if (fields.length == 0) {
            return this.videos.get(id).toString();
        }
        return this.fieldJsonMapper.toJson(this.videos.get(id), fields);
    }
}
