package com.sensiblemetrics.api.alpenidos.core.throttling.model;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A class to keep track of the counter of different Tenants
 *
 * @author drastogi
 */
@Slf4j
public final class CallsCount {
    private final Map<String, AtomicLong> tenantCallsCount = new ConcurrentHashMap<>();

    /**
     * Add a new tenant to the map.
     *
     * @param tenantName name of the tenant.
     */
    public void addTenant(final String tenantName) {
        this.tenantCallsCount.putIfAbsent(tenantName, new AtomicLong(0));
    }

    /**
     * Increment the count of the specified tenant.
     *
     * @param tenantName name of the tenant.
     */
    public void incrementCount(final String tenantName) {
        this.tenantCallsCount.get(tenantName).incrementAndGet();
    }

    /**
     * @param tenantName name of the tenant.
     * @return the count of the tenant.
     */
    public long getCount(final String tenantName) {
        return this.tenantCallsCount.get(tenantName).get();
    }

    /**
     * Resets the count of all the tenants in the map.
     */
    public void reset() {
        log.debug("Resetting the map.");
        this.tenantCallsCount.entrySet().forEach(e -> this.tenantCallsCount.put(e.getKey(), new AtomicLong(0)));
    }
}
