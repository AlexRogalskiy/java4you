package com.sensiblemetrics.api.alpenidos.core.service_locator.config;

import com.sensiblemetrics.api.alpenidos.core.service_locator.cache.ServiceCache;
import com.sensiblemetrics.api.alpenidos.core.service_locator.iface.Service;
import lombok.experimental.UtilityClass;

/**
 * The service locator module. Will fetch service from cache, otherwise creates a fresh service and update cache
 */
@UtilityClass
public class ServiceLocator {

    private static final ServiceCache serviceCache = new ServiceCache();

    /**
     * Fetch the service with the name param from the cache first, if no service is found, lookup the service from the {@link InitContext} and then add the
     * newly created service into the cache map for future requests.
     *
     * @param serviceJndiName a string
     * @return {@link Service}
     */
    public static Service getService(final String serviceJndiName) {
        Service serviceObj = serviceCache.getService(serviceJndiName);
        if (serviceObj != null) {
            return serviceObj;
        }
        /*
         * If we are unable to retrive anything from cache, then lookup the service and add it in the
         * cache map
         */
        final InitContext ctx = new InitContext();
        serviceObj = (Service) ctx.lookup(serviceJndiName);
        if (serviceObj != null) {
            serviceCache.addService(serviceObj);
        }

        return serviceObj;
    }
}
