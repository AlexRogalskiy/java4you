package com.sensiblemetrics.api.alpenidos.core.cor2.handler;

import com.sensiblemetrics.api.alpenidos.core.cor2.impl.Command;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DirectorPower extends PurchasePower {
    private static final int ALLOW = BASE * 20;

    @Override
    public void handleRequest(final Command command) {
        if (command.getAmount() <= ALLOW) {
            log.info("Sale handled by Director");
        } else {
            if (this.getSuccessor() != null) {
                this.getSuccessor().handleRequest(command);
            }
        }
    }
}
