package com.sensiblemetrics.api.alpenidos.core.api_gateway.price_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes the Price microservice's endpoints
 */
@RestController
public class PriceController {

    /**
     * An endpoint for a user to retrieve a product's price
     *
     * @return A product's price
     */
    @GetMapping("/price")
    public String getPrice() {
        return "20";
    }
}
