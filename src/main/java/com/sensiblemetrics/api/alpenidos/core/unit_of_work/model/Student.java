package com.sensiblemetrics.api.alpenidos.core.unit_of_work.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * {@link Student} is an entity.
 */
@Data
@RequiredArgsConstructor
public class Student {
    private final Integer id;
    private final String name;
    private final String address;
}
