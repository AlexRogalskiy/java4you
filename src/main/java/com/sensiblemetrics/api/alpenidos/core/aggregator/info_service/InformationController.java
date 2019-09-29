package com.sensiblemetrics.api.alpenidos.core.aggregator.info_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller providing endpoints to retrieve information about products
 */
@RestController
public class InformationController {

    /**
     * Endpoint to retrieve a product's informations.
     *
     * @return product inventory.
     */
    @GetMapping("/information")
    public String getProductTitle() {
        return "The Product Title.";
    }
}
