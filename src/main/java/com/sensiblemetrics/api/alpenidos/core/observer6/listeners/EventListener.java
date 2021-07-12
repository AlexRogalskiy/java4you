package com.sensiblemetrics.api.alpenidos.core.observer6.listeners;

import java.io.File;

@FunctionalInterface
public interface EventListener {

    void update(String eventType, File file);
}
