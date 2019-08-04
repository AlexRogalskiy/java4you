package com.sensiblemetrics.api.alpenidos.core.filter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order class carries the order data.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String name;
    private String contactNumber;
    private String address;
    private String depositNumber;
    private String orderItem;
}
