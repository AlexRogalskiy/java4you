package com.sensiblemetrics.api.alpenidos.core.cor2.handler;

import com.sensiblemetrics.api.alpenidos.core.cor2.handler.PurchasePower;
import com.sensiblemetrics.api.alpenidos.core.cor2.impl.Command;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VicePresident extends PurchasePower {
    private static final int ALLOW = BASE * 30;

    @Override
    void handleRequest(final Command command) {
        log.info("Sale handled by Vice President");
    }
}
