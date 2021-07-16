package com.sensiblemetrics.api.alpenidos.core.singleton3;

class LazySingletonAnswer {

    private static class ResourceHolder {

        static Resource resource = new Resource();
    }

    static Resource getInstance() {
        return ResourceHolder.resource;
    }
}
