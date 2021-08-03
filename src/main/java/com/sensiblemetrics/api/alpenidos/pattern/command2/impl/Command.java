package com.sensiblemetrics.api.alpenidos.pattern.command2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.command2.model.Target;

/**
 * Interface for Commands.
 */
public abstract class Command {

    public abstract void execute(final Target target);

    public abstract void undo();

    public abstract void redo();

    @Override
    public abstract String toString();
}
