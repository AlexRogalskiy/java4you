package com.sensiblemetrics.api.alpenidos.core.service_locator.cache;

import com.sensiblemetrics.api.alpenidos.core.service_locator.iface.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * The service cache implementation which will cache services that are being created. On first hit,
 * the cache will be empty and thus any service that is being requested, will be created fresh and
 * then placed into the cache map. On next hit, if same service name will be requested, it will be
 * returned from the cache
 *
 * @author saifasif
 */
@Slf4j
public class ServiceCache {
    private final Map<String, Service> serviceCache;

    public ServiceCache() {
        this.serviceCache = new HashMap<>();
    }

    /**
     * Get the service from the cache. null if no service is found matching the name
     *
     * @param serviceName a string
     * @return {@link Service}
     */
    public Service getService(final String serviceName) {
        Service cachedService = null;
        for (final String serviceJndiName : this.serviceCache.keySet()) {
            if (serviceJndiName.equals(serviceName)) {
                cachedService = this.serviceCache.get(serviceJndiName);
                log.info("(cache call) Fetched service {}({}) from cache... !", cachedService.getName(), cachedService.getId());
            }
        }
        return cachedService;
    }

    /**
     * Adds the service into the cache map
     *
     * @param newService a {@link Service}
     */
    public void addService(final Service newService) {
        this.serviceCache.put(newService.getName(), newService);
    }
}
