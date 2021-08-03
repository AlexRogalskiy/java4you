package com.sensiblemetrics.api.alpenidos.pattern.locator.impl;

import com.sensiblemetrics.api.alpenidos.pattern.locator.iface.MessagingService;

import java.util.Objects;

public class ServiceLocator {

    private static Cache cache;

    static {
        cache = new Cache();
    }

    public static MessagingService getService(final String serviceName) {
        final MessagingService service = cache.getService(serviceName);
        if (Objects.nonNull(service)) {
            return service;
        }
        final InitialContext context = new InitialContext();
        final MessagingService messagingService = (MessagingService) context.lookup(serviceName);
        cache.addService(messagingService);
        return messagingService;
    }
}
