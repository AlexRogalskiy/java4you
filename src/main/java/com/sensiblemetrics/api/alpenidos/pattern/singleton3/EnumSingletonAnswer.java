package com.sensiblemetrics.api.alpenidos.pattern.singleton3;

enum EnumSingletonAnswer {
    INSTANCE;

    private final Resource resource = new Resource();

    static Resource getInstance() {
        return INSTANCE.resource;
    }
}
