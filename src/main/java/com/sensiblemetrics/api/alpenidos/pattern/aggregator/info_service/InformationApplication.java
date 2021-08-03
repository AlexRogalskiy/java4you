package com.sensiblemetrics.api.alpenidos.pattern.aggregator.info_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Inventory Application starts container (Spring Boot) and exposes the Inventory micro-service.
 */
@SpringBootApplication
public class InformationApplication {

    public static void main(final String[] args) {
        SpringApplication.run(InformationApplication.class, args);
    }
}
