package com.sensiblemetrics.api.alpenidos.pattern.ambassador.iface;

import com.sensiblemetrics.api.alpenidos.pattern.ambassador.impl.RemoteService;
import com.sensiblemetrics.api.alpenidos.pattern.ambassador.impl.ServiceAmbassador;

/**
 * Interface shared by ({@link RemoteService}) and ({@link ServiceAmbassador}).
 */
public interface RemoteServiceInterface {
    int FAILURE = -1;

    long doRemoteFunction(final int value) throws Exception;
}
