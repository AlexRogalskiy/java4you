package com.sensiblemetrics.api.alpenidos.core.ambassador.iface;

import com.sensiblemetrics.api.alpenidos.core.ambassador.impl.RemoteService;
import com.sensiblemetrics.api.alpenidos.core.ambassador.impl.ServiceAmbassador;

/**
 * Interface shared by ({@link RemoteService}) and ({@link ServiceAmbassador}).
 */
public interface RemoteServiceInterface {
    int FAILURE = -1;

    long doRemoteFunction(int value) throws Exception;
}
