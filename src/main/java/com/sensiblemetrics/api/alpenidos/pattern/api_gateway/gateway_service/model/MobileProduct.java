package com.sensiblemetrics.api.alpenidos.pattern.api_gateway.gateway_service.model;

import lombok.Data;

/**
 * Encapsulates all of the information that mobile client needs to display a product.
 */
@Data
public class MobileProduct {
    /**
     * The price of the product
     */
    private String price;
}
