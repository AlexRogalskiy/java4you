package com.sensiblemetrics.api.alpenidos.core.ambassador.impl;

import com.sensiblemetrics.api.alpenidos.core.ambassador.client.Client;
import com.sensiblemetrics.api.alpenidos.core.ambassador.iface.RemoteServiceInterface;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * ServiceAmbassador provides an interface for a ({@link Client}) to access ({@link RemoteService}).
 * The interface adds logging, latency testing and usage of the service in a safe way that will not
 * add stress to the remote service when connectivity issues occur.
 */
@Slf4j
@NoArgsConstructor
public class ServiceAmbassador implements RemoteServiceInterface {
    /**
     * Default constants
     */
    private static final int RETRIES = 3;
    private static final int DELAY_MS = 3000;

    @Override
    public long doRemoteFunction(int value) {
        return this.safeCall(value);
    }

    private long checkLatency(int value) {
        final long startTime = System.currentTimeMillis();
        final long result = RemoteService.getRemoteService().doRemoteFunction(value);
        final long timeTaken = System.currentTimeMillis() - startTime;

        log.info("Time taken (ms): " + timeTaken);
        return result;
    }

    private long safeCall(int value) {
        int retries = 0;
        long result = FAILURE;

        for (int i = 0; i < RETRIES; i++) {

            if (retries >= RETRIES) {
                return FAILURE;
            }

            if ((result = this.checkLatency(value)) == FAILURE) {
                log.info("Failed to reach remote: (" + (i + 1) + ")");
                retries++;
                try {
                    sleep(DELAY_MS);
                } catch (InterruptedException e) {
                    log.error("Thread sleep state interrupted", e);
                }
            } else {
                break;
            }
        }
        return result;
    }
}
