package com.sensiblemetrics.api.alpenidos.pattern.aggregator.aggregator_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Encapsulates all the data for a Product that clients will request.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /**
     * The title of the product.
     */
    private String title;

    /**
     * The inventories of the product.
     */
    private int productInventories;
}
