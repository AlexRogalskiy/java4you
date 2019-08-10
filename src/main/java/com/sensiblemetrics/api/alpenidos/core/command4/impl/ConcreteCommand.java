package com.sensiblemetrics.api.alpenidos.core.command4.impl;

import com.sensiblemetrics.api.alpenidos.core.command4.Receiver;
import com.sensiblemetrics.api.alpenidos.core.command4.iface.Command;
import lombok.RequiredArgsConstructor;

/**
 * ConcreteCommand class, defines a binding between a Receiver object and an
 * operation
 */
@RequiredArgsConstructor
public class ConcreteCommand implements Command {
    private final Receiver receiver;

    public void execute() {
        this.receiver.action();
    }
}
