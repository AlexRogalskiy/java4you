package com.sensiblemetrics.api.alpenidos.core.aggregator.inventory_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Inventory Application starts container (Spring Boot) and exposes the Inventory micro-service.
 */
@SpringBootApplication
public class InventoryApplication {

    public static void main(final String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }
}
