package com.sensiblemetrics.api.alpenidos.core.iterator3.iface;

public interface MyIterator {
    void first();

    void next();

    boolean isLast();

    Object currentItem();
}
