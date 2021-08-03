package com.sensiblemetrics.api.alpenidos.pattern.converter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User class
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String userId;
}
