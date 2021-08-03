package com.sensiblemetrics.api.alpenidos.pattern.filtero.iface;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode
@ToString
public class OrderImpl implements Order {
    private String username;
    private Map<Book, Integer> items = new HashMap<>();

    @Override
    public void add(final Book item, final Integer quantity) {
        Integer initialQuantity = 0;
        if (this.items.containsKey(item)) {
            initialQuantity = this.items.get(item);
        }
        this.items.put(item, quantity + initialQuantity);
    }
}
