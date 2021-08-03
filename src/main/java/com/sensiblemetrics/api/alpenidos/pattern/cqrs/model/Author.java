package com.sensiblemetrics.api.alpenidos.pattern.cqrs.model;

import lombok.Data;

/**
 * This is a DTO (Data Transfer Object) author, contains only useful information to be returned
 */
@Data
public class Author {
    private String name;
    private String email;
    private String username;
}
