package com.sensiblemetrics.api.alpenidos.core.prototype.iface;

public class PrototypeFactory {

    public Prototype getClone(final Prototype proto) {
        return proto.clone();
    }
}
