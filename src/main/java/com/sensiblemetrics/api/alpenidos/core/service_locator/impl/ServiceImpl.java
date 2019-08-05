package com.sensiblemetrics.api.alpenidos.core.service_locator.impl;

import com.sensiblemetrics.api.alpenidos.core.service_locator.iface.Service;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * This is a single service implementation of a sample service. This is the actual service that will
 * process the request. The reference for this service is to be looked upon in the JNDI server that
 * can be set in the web.xml deployment descriptor
 */
@Slf4j
@Data
public class ServiceImpl implements Service {
    private final String serviceName;
    private final int id;

    /**
     * Constructor
     */
    public ServiceImpl(final String serviceName) {
        // set the service name
        this.serviceName = serviceName;
        // Generate a random id to this service object
        this.id = (int) Math.floor(Math.random() * 1000) + 1;
    }

    @Override
    public String getName() {
        return this.serviceName;
    }

    @Override
    public void execute() {
        log.info("Service {} is now executing with id {}", this.getName(), this.getId());
    }
}
