package com.sensiblemetrics.api.alpenidos.pattern.ambassador.impl;

import com.sensiblemetrics.api.alpenidos.pattern.ambassador.iface.RandomProvider;
import com.sensiblemetrics.api.alpenidos.pattern.ambassador.iface.RemoteServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * A remote legacy application represented by a Singleton implementation.
 */
@Slf4j
@RequiredArgsConstructor
public class RemoteService implements RemoteServiceInterface {
    public static final int THRESHOLD = 200;
    private static RemoteService service = null;
    private final RandomProvider randomProvider;

    public static synchronized RemoteService getRemoteService() {
        if (service == null) {
            service = new RemoteService();
        }
        return service;
    }

    private RemoteService() {
        this(Math::random);
    }

    /**
     * Remote function takes a value and multiplies it by 10 taking a random amount of time.
     * Will sometimes return -1. This imitates connectivity issues a client might have to account for.
     *
     * @param value integer value to be multiplied.
     * @return if waitTime is less than {@link RemoteService#THRESHOLD}, it returns value * 10,
     * otherwise {@link RemoteServiceInterface#FAILURE}.
     */
    @Override
    public long doRemoteFunction(int value) {
        final long waitTime = (long) Math.floor(this.randomProvider.random() * 1000);

        try {
            sleep(waitTime);
        } catch (InterruptedException e) {
            log.error("Thread sleep state interrupted", e);
        }
        return waitTime <= THRESHOLD ? value * 10 : FAILURE;
    }
}
