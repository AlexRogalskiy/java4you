package com.sensiblemetrics.api.alpenidos.pattern.iterator3.iface;

public interface MyIterator {
    void first();

    void next();

    boolean isLast();

    Object currentItem();
}
