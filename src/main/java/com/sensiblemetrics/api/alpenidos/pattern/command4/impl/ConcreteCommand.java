package com.sensiblemetrics.api.alpenidos.pattern.command4.impl;

import com.sensiblemetrics.api.alpenidos.pattern.command4.Receiver;
import com.sensiblemetrics.api.alpenidos.pattern.command4.iface.Command;
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
