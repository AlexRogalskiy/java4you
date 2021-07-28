package com.sensiblemetrics.api.alpenidos.core.visitor7;

/**
 * @author Alexander Pashinskiy
 * @version 1.0
 * @since 12/06/2016
 */
public interface Visitor<T> {

    T visit(Circle circle);

    T visit(Rectangle rectangle);

    T visit(Square square);
}
