package com.sensiblemetrics.api.alpenidos.pattern.business_delegate.impl;

import com.sensiblemetrics.api.alpenidos.pattern.business_delegate.iface.BusinessService;
import lombok.extern.slf4j.Slf4j;

/**
 * Service JMS implementation
 */
@Slf4j
public class JmsService implements BusinessService {

    @Override
    public void doProcessing() {
        log.info("JmsService is now processing");
    }
}
