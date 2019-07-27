package com.sensiblemetrics.api.alpenidos.core.locator.impl;

import com.sensiblemetrics.api.alpenidos.core.locator.iface.MessagingService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gebruiker on 4/20/2018.
 */
public class Cache {
    private final List<MessagingService> services = new ArrayList<>();

    public MessagingService getService(final String serviceName) {
        for (final MessagingService service : this.services) {
            if (service.getServiceName().equalsIgnoreCase(serviceName)) {
                System.out.println("Returning cached  " + serviceName + " object");
                return service;
            }
        }
        return null;
    }

    public void addService(final MessagingService newService) {
        boolean exists = false;
        for (final MessagingService service : this.services) {
            if (service.getServiceName().equalsIgnoreCase(newService.getServiceName())) {
                exists = true;
            }
        }
        if (!exists) {
            this.services.add(newService);
        }
    }
}
