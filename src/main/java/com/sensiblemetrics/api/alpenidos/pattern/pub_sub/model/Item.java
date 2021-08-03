package com.sensiblemetrics.api.alpenidos.pattern.pub_sub.model;

import com.sensiblemetrics.api.alpenidos.pattern.pub_sub.impl.Producer;
import com.sensiblemetrics.api.alpenidos.pattern.pub_sub.impl.Consumer;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Class take part of an {@link Producer}-{@link Consumer} exchange.
 */
@Getter
@AllArgsConstructor
public class Item {
    private String producer;
    private int id;
}
