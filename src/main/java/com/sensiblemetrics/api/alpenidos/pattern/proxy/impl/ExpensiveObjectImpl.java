package com.sensiblemetrics.api.alpenidos.pattern.proxy.impl;

import com.sensiblemetrics.api.alpenidos.pattern.proxy.iface.ExpensiveObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExpensiveObjectImpl implements ExpensiveObject {

    public ExpensiveObjectImpl() {
        this.heavyInitialConfiguration();
    }

    @Override
    public void process() {
        log.info("processing complete.");
    }

    private void heavyInitialConfiguration() {
        log.info("Loading initial configuration..");
    }
}
