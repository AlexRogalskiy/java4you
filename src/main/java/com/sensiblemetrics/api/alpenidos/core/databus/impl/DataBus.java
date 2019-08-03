package com.sensiblemetrics.api.alpenidos.core.databus.impl;

import com.sensiblemetrics.api.alpenidos.core.databus.iface.DataType;
import com.sensiblemetrics.api.alpenidos.core.databus.iface.Member;

import java.util.HashSet;
import java.util.Set;

/**
 * The Data-Bus implementation.
 *
 * <p>This implementation uses a Singleton.</p>
 *
 * @author Paul Campbell (pcampbell@kemitix.net)
 */
public class DataBus {

    /**
     * Default {@link DataBus} instance
     */
    private static final DataBus INSTANCE = new DataBus();

    private final Set<Member> listeners = new HashSet<>();

    public static DataBus getInstance() {
        return INSTANCE;
    }

    /**
     * Register a member with the data-bus to start receiving events.
     *
     * @param member The member to register
     */
    public void subscribe(final Member member) {
        this.listeners.add(member);
    }

    /**
     * Deregister a member to stop receiving events.
     *
     * @param member The member to deregister
     */
    public void unsubscribe(final Member member) {
        this.listeners.remove(member);
    }

    /**
     * Publish and event to all members.
     *
     * @param event The event
     */
    public void publish(final DataType event) {
        event.setDataBus(this);
        this.listeners.forEach(listener -> listener.accept(event));
    }
}
