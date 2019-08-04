package com.sensiblemetrics.api.alpenidos.core.map_reduce.model;

import lombok.RequiredArgsConstructor;

/**
 * The abstract Result class, which contains 1 public field containing result
 * data.
 *
 * @param <T> T will be type of data.
 */
@RequiredArgsConstructor
public abstract class Result<T> {
    public final T data;
}
