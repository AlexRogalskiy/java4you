package com.sensiblemetrics.api.alpenidos.pattern.fsm.iface;

import java.io.Serializable;

/**
 * State interface declaration
 *
 * @param <C>
 * @param <T>
 * @author Alex
 * @version 1.0.0
 * @since 2017-08-07
 */
public interface State<C, T> extends Serializable {

    State<C, T> add(final T transition);

    State<C, T> remove(final T transition);

    State<C, T> transit(final C value);

    boolean isFinal();
}
