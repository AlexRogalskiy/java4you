package com.sensiblemetrics.api.alpenidos.core.visitor7;

/**
 * @author Alexander Pashinskiy
 * @since 12/06/2016
 * @version 1.0
 */
public interface Element {
    <T> T accept(Visitor<T> visitor);
}
