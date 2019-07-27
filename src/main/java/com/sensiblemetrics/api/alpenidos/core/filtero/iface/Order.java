package com.sensiblemetrics.api.alpenidos.core.filtero.iface;

import java.util.Map;

public interface Order {

    String getUsername();

    Map<Book, Integer> getItems();

    void add(final Book item, final Integer quantity);
}
