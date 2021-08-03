package com.sensiblemetrics.api.alpenidos.pattern.dao2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A customer POJO that represents the data that will be read from the data source.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
}
