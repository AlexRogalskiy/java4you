package com.sensiblemetrics.api.alpenidos.pattern.partial_response.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * {@link Video} is a entity to serve from server.It contains all video related information..
 * <p>
 */
@Data
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class Video {
    private final Integer id;
    private final String title;
    private final Integer length;
    private final String description;
    private final String director;
    private final String language;
}
