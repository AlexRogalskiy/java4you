package com.sensiblemetrics.api.alpenidos.core.objectpool.impl;

import com.sensiblemetrics.api.alpenidos.core.objectpool.iface.Resource;

public class RealResource implements Resource {
    private final long creationTime;

    public RealResource() {
        this.creationTime = System.nanoTime();
    }

    @Override
    public void print() {
        System.out.println(this.creationTime);
    }

    @Override
    public void close() {
    }
}
