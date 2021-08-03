package com.sensiblemetrics.api.alpenidos.pattern.service_locator.config;

import com.sensiblemetrics.api.alpenidos.pattern.service_locator.iface.Service;
import com.sensiblemetrics.api.alpenidos.pattern.service_locator.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * For JNDI lookup of services from the web.xml. Will match name of the service name that is being
 * requested and return a newly created service object with the name
 *
 * @author saifasif
 */
@Slf4j
public class InitContext {

    /**
     * Perform the lookup based on the service name. The returned object will need to be casted into a
     * {@link Service}
     *
     * @param serviceName a string
     * @return an {@link Object}
     */
    public Object lookup(final String serviceName) {
        if (serviceName.equals("jndi/serviceA")) {
            log.info("Looking up service A and creating new service for A");
            return new ServiceImpl("jndi/serviceA");
        } else if (serviceName.equals("jndi/serviceB")) {
            log.info("Looking up service B and creating new service for B");
            return new ServiceImpl("jndi/serviceB");
        }
        return null;
    }
}
