package com.sensiblemetrics.api.alpenidos.pattern.ambassador.client;

import com.sensiblemetrics.api.alpenidos.pattern.ambassador.impl.ServiceAmbassador;
import lombok.extern.slf4j.Slf4j;

/**
 * A simple SimpleFactoryPatternLoader
 */
@Slf4j
public class Client {
    private final ServiceAmbassador serviceAmbassador = new ServiceAmbassador();

    public long useService(int value) {
        final long result = this.serviceAmbassador.doRemoteFunction(value);
        log.info("Service result: " + result);
        return result;
    }
}
