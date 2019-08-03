package com.sensiblemetrics.api.alpenidos.core.cqrs.model;

import lombok.Data;

/**
 * This is a DTO (Data Transfer Object) book, contains only useful information to be returned
 */
@Data
public class Book {
    private String title;
    private double price;
}
