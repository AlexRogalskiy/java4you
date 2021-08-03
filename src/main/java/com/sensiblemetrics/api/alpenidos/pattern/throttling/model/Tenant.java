package com.sensiblemetrics.api.alpenidos.pattern.throttling.model;

import lombok.Getter;

import java.security.InvalidParameterException;

/**
 * A Pojo class to create a basic Tenant with the allowed calls per second.
 */
@Getter
public class Tenant {
    private String name;
    private int allowedCallsPerSecond;

    /**
     * @param name                  Name of the tenant
     * @param allowedCallsPerSecond The number of calls allowed for a particular tenant.
     * @throws InvalidParameterException If number of calls is less than 0, throws exception.
     */
    public Tenant(final String name, final int allowedCallsPerSecond, final CallsCount callsCount) {
        if (allowedCallsPerSecond < 0) {
            throw new InvalidParameterException("Number of calls less than 0 not allowed");
        }
        this.name = name;
        this.allowedCallsPerSecond = allowedCallsPerSecond;
        callsCount.addTenant(name);
    }
}
