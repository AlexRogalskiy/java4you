package com.sensiblemetrics.api.alpenidos.pattern.command2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.command2.model.Target;
import com.sensiblemetrics.api.alpenidos.pattern.command2.enums.Visibility;

import java.util.Optional;

/**
 * InvisibilitySpell is a concrete command
 */
public class InvisibilitySpell extends Command {

    private Target target;

    @Override
    public void execute(final Target target) {
        target.setVisibility(Visibility.INVISIBLE);
        this.target = target;
    }

    @Override
    public void undo() {
        Optional.ofNullable(this.target).ifPresent(t -> t.setVisibility(Visibility.VISIBLE));
    }

    @Override
    public void redo() {
        Optional.ofNullable(this.target).ifPresent(t -> t.setVisibility(Visibility.INVISIBLE));
    }

    @Override
    public String toString() {
        return "Invisibility spell";
    }
}
