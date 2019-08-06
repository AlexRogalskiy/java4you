package com.sensiblemetrics.api.alpenidos.core.throttling;

import com.sensiblemetrics.api.alpenidos.core.throttling.iface.Throttler;
import com.sensiblemetrics.api.alpenidos.core.throttling.impl.ThrottleTimerImpl;
import com.sensiblemetrics.api.alpenidos.core.throttling.model.CallsCount;
import com.sensiblemetrics.api.alpenidos.core.throttling.model.Tenant;
import com.sensiblemetrics.api.alpenidos.core.throttling.service.B2BService;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Throttling pattern is a design pattern to throttle or limit the use of resources or even a complete service by
 * users or a particular tenant. This can allow systems to continue to function and meet service level agreements,
 * even when an increase in demand places load on resources.
 * <p>
 * In this example we have ({@link ThrottlingPatternLoader}) as the initiating point of the service.
 * This is a time based throttling, i.e. only a certain number of calls are allowed per second.
 * </p>
 * ({@link Tenant}) is the Tenant POJO class with which many tenants can be created
 * ({@link B2BService}) is the service which is consumed by the tenants and is throttled.
 */
@Slf4j
public class ThrottlingPatternLoader {

    /**
     * Application entry point
     *
     * @param args main arguments
     */
    public static void main(final String[] args) {
        final CallsCount callsCount = new CallsCount();
        final Tenant adidas = new Tenant("Adidas", 5, callsCount);
        final Tenant nike = new Tenant("Nike", 6, callsCount);

        final ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(() -> makeServiceCalls(adidas, callsCount));
        executorService.execute(() -> makeServiceCalls(nike, callsCount));

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Executor Service terminated: {}", e.getMessage());
        }
    }

    /**
     * Make calls to the B2BService dummy API
     */
    private static void makeServiceCalls(final Tenant tenant, final CallsCount callsCount) {
        final Throttler timer = new ThrottleTimerImpl(10, callsCount);
        final B2BService service = new B2BService(timer, callsCount);
        for (int i = 0; i < 20; i++) {
            service.dummyCustomerApi(tenant);
            // Sleep is introduced to keep the output in check and easy to view and analyze the results.
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                log.error("Thread interrupted: {}", e.getMessage());
            }
        }
    }
}
