package com.sensiblemetrics.api.alpenidos.pattern.event.asynchronous.iface;

/**
 * Events that fulfill the start stop and list out current status behaviour
 * follow this interface
 */
public interface IEvent {

    void start();

    void stop();

    void status();
}
