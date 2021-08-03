package com.sensiblemetrics.api.alpenidos.pattern.object_pool.iface;

@FunctionalInterface
public interface ResourceFactory {

    Resource get();
}
