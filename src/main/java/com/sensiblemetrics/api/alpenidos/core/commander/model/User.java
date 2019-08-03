package com.sensiblemetrics.api.alpenidos.core.commander.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User class contains details of user who places order.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String address;
}
