package com.sensiblemetrics.api.alpenidos.core.api_gateway.gateway_service.model;

import lombok.Data;

/**
 * Encapsulates all of the information that a desktop client needs to display a product.
 */
@Data
public class DesktopProduct {
    /**
     * The price of the product
     */
    private String price;

    /**
     * The path to the image of the product
     */
    private String imagePath;
}
