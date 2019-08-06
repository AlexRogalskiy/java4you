package com.sensiblemetrics.api.alpenidos.core.throttling.service;

import com.sensiblemetrics.api.alpenidos.core.throttling.iface.Throttler;
import com.sensiblemetrics.api.alpenidos.core.throttling.model.CallsCount;
import com.sensiblemetrics.api.alpenidos.core.throttling.model.Tenant;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A service which accepts a tenant and throttles the resource based on the time given to the tenant.
 */
@Slf4j
public class B2BService {
    private final CallsCount callsCount;

    public B2BService(final Throttler timer, final CallsCount callsCount) {
        this.callsCount = callsCount;
        timer.start();
    }

    /**
     * @return customer id which is randomly generated
     */
    public int dummyCustomerApi(final Tenant tenant) {
        final String tenantName = tenant.getName();
        final long count = this.callsCount.getCount(tenantName);
        log.debug("Counter for {} : {} ", tenant.getName(), count);

        if (count >= tenant.getAllowedCallsPerSecond()) {
            log.error("API access per second limit reached for: {}", tenantName);
            return -1;
        }
        this.callsCount.incrementCount(tenantName);
        return this.getRandomCustomerId();
    }

    private int getRandomCustomerId() {
        return ThreadLocalRandom.current().nextInt(1, 10000);
    }
}
