package com.sensiblemetrics.api.alpenidos.pattern.business_delegate.impl;

import com.sensiblemetrics.api.alpenidos.pattern.business_delegate.iface.BusinessService;
import lombok.extern.slf4j.Slf4j;

/**
 * Service EJB implementation
 */
@Slf4j
public class EjbService implements BusinessService {

    @Override
    public void doProcessing() {
        log.info("EjbService is now processing");
    }
}
