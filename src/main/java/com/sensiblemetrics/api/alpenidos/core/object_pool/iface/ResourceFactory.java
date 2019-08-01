package com.sensiblemetrics.api.alpenidos.core.object_pool.iface;

@FunctionalInterface
public interface ResourceFactory {

    Resource get();
}
