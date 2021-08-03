package com.sensiblemetrics.api.alpenidos.pattern.adaptor.client;

import com.sensiblemetrics.api.alpenidos.pattern.adaptor.impl.Adapter;
import com.sensiblemetrics.api.alpenidos.pattern.adaptor.impl.ConcreteTarget;
import com.sensiblemetrics.api.alpenidos.pattern.adaptor.impl.ITarget;

public class AdapterClient {

    public static void main(final String[] args) {
        final ITarget adapter = new Adapter();
        adapter.request();

        final ITarget target = new ConcreteTarget();
        target.request();
    }
}
