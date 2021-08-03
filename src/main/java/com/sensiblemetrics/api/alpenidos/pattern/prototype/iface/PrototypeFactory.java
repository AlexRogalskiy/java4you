package com.sensiblemetrics.api.alpenidos.pattern.prototype.iface;

public class PrototypeFactory {

    public Prototype getClone(final Prototype proto) {
        return proto.clone();
    }
}
