package com.sensiblemetrics.api.alpenidos.core.command4;

import com.sensiblemetrics.api.alpenidos.core.command4.iface.Command;
import lombok.RequiredArgsConstructor;

/**
 * Invoker class, asks the command to carry out the request
 */
@RequiredArgsConstructor
public class Invoker {
    private final Command command;

    public void execute() {
        this.command.execute();
    }
}
