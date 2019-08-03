package com.sensiblemetrics.api.alpenidos.core.collection_pipeline.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * A Person class that has the list of cars that the person owns and use.
 */
@Data
@RequiredArgsConstructor
public class Person {
    private final List<Car> cars;
}
