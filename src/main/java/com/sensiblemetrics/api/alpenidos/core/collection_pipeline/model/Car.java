package com.sensiblemetrics.api.alpenidos.core.collection_pipeline.model;

import com.sensiblemetrics.api.alpenidos.core.collection_pipeline.enums.Category;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * A Car class that has the properties of make, model, year and category.
 */
@Data
@RequiredArgsConstructor
public class Car {
    private final String make;
    private final String model;
    private final int year;
    private final Category category;
}
