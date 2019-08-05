package com.sensiblemetrics.api.alpenidos.core.partial_response.mapper;

import com.sensiblemetrics.api.alpenidos.core.partial_response.model.Video;

import java.lang.reflect.Field;

/**
 * Map a video to json
 */
public class FieldJsonMapper {

    /**
     * @param video  object containing video information
     * @param fields fields information to get
     * @return json of required fields from video
     */
    public String toJson(final Video video, final String[] fields) throws Exception {
        final StringBuilder json = new StringBuilder().append("{");
        for (int i = 0, fieldsLength = fields.length; i < fieldsLength; i++) {
            json.append(getString(video, Video.class.getDeclaredField(fields[i])));
            if (i != fieldsLength - 1) {
                json.append(",");
            }
        }
        json.append("}");
        return json.toString();
    }

    private String getString(final Video video, final Field declaredField) throws IllegalAccessException {
        declaredField.setAccessible(true);
        final Object value = declaredField.get(video);
        if (declaredField.get(video) instanceof Integer) {
            return "\"" + declaredField.getName() + "\"" + ": " + value;
        }
        return "\"" + declaredField.getName() + "\"" + ": " + "\"" + value.toString() + "\"";
    }
}
