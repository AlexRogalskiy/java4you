package com.sensiblemetrics.api.alpenidos.core.adaptor.client;

import com.sensiblemetrics.api.alpenidos.core.adaptor.impl.Adapter;
import com.sensiblemetrics.api.alpenidos.core.adaptor.impl.ConcreteTarget;
import com.sensiblemetrics.api.alpenidos.core.adaptor.impl.ITarget;

public class AdapterClient {

    public static void main(final String[] args) {
        final ITarget adapter = new Adapter();
        adapter.request();

        final ITarget target = new ConcreteTarget();
        target.request();
    }
}
