package com.sensiblemetrics.api.alpenidos.core.memento.impl;

import com.sensiblemetrics.api.alpenidos.core.memento.model.Memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    private final List<Memento> savedStates = new ArrayList<>();

    public void add(final Memento state) {
        this.savedStates.add(state);
    }

    public Memento get(int index) {
        return this.savedStates.get(index);
    }
}
