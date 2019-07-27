package com.sensiblemetrics.api.alpenidos.core.objectpool.impl;

import com.sensiblemetrics.api.alpenidos.core.objectpool.iface.Resource;
import com.sensiblemetrics.api.alpenidos.core.objectpool.iface.ResourceFactory;

public class RealResourceFactory implements ResourceFactory {

    @Override
    public Resource get() {
        return new RealResource();
    }
}
