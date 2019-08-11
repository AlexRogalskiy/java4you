package com.sensiblemetrics.api.alpenidos.core.cor2.handler;

import com.sensiblemetrics.api.alpenidos.core.cor2.impl.Command;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ManagerPower extends PurchasePower {
    private static final int ALLOW = BASE * 10;

    @Override
    void handleRequest(final Command command) {
        if (command.getAmount() <= ALLOW) {
            log.info("Sale handled by Manager");
        } else {
            if (this.getSuccessor() != null) {
                this.getSuccessor().handleRequest(command);
            }
        }
    }
}
