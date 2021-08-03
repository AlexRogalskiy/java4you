package com.sensiblemetrics.api.alpenidos.pattern.memento4.handler;

import com.sensiblemetrics.api.alpenidos.pattern.memento4.model.Memento;
import java.util.ArrayList;
import java.util.List;

public class CareTaker {

    private final List<Memento> mementoList = new ArrayList<>();

    public void add(final Memento state) {
        this.mementoList.add(state);
    }

    public Memento get(final int index) {
        return this.mementoList.get(index);
    }
}
