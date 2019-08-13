package com.sensiblemetrics.api.alpenidos.core.command5.model;

import com.sensiblemetrics.api.alpenidos.core.command5.enums.EOperator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Command {
    protected final Object receiver;
    protected final EOperator operator;
    protected final int operand;

    public abstract void execute();

    public abstract void unExecute();
}
