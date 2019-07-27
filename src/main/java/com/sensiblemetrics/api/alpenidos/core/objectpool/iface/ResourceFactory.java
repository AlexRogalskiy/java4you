package com.sensiblemetrics.api.alpenidos.core.objectpool.iface;

import com.sensiblemetrics.api.alpenidos.core.objectpool.iface.Resource;

@FunctionalInterface
public interface ResourceFactory {

    Resource get();
}
