package com.sensiblemetrics.api.alpenidos.core.map_reduce.model;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

/**
 * The abstract Input class, having 1 public field which contains input data,
 * and abstract method divideData.
 *
 * @param <T> T will be type of data.
 */
@RequiredArgsConstructor
public abstract class Input<T> {
    public final T data;

    public abstract ArrayList<Input> divideData(final int num);
}
