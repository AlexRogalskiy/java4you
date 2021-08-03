package com.sensiblemetrics.api.alpenidos.pattern.object_pool.impl;

import com.sensiblemetrics.api.alpenidos.pattern.object_pool.iface.Resource;

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
