/*
 * The MIT License
 *
 * Copyright 2018 WildBees Labs.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sensiblemetrics.api.alpenidos.pattern.fsm2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.fsm2.iface.ICState;
import com.sensiblemetrics.api.alpenidos.pattern.fsm2.iface.ICTransition;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom state implementation
 *
 * @param <C>
 * @param <T>
 * @author Alex
 * @version 1.0.0
 * @since 2017-08-07
 */
@Data
@EqualsAndHashCode
@ToString
public class CState<C, T extends ICTransition<C, ICState<C, T>>> implements ICState<C, T> {
    protected final List<T> transitions = new ArrayList<>();
    protected boolean isFinal;

    public CState() {
        this(false);
    }

    public CState(final boolean isFinal) {
        this.isFinal = isFinal;
    }

    @Override
    public ICState<C, T> transit(final C value) {
        return this.transitions
            .stream()
            .filter(t -> t.isPossible(value))
            .map(ICTransition::state)
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("Input not accepted: " + value));
    }

    @Override
    public boolean isFinal() {
        return this.isFinal;
    }

    @Override
    public ICState<C, T> add(final T transition) {
        this.transitions.add(transition);
        return this;
    }

    @Override
    public ICState<C, T> remove(final T transition) {
        this.transitions.remove(transition);
        return this;
    }
}
