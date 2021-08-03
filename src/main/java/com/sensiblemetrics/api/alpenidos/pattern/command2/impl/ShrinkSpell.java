package com.sensiblemetrics.api.alpenidos.pattern.command2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.command2.model.Target;
import com.sensiblemetrics.api.alpenidos.pattern.command2.enums.Size;

/**
 * ShrinkSpell is a concrete command
 */
public class ShrinkSpell extends Command {
    private Size oldSize;
    private Target target;

    @Override
    public void execute(final Target target) {
        this.oldSize = target.getSize();
        target.setSize(Size.SMALL);
        this.target = target;
    }

    @Override
    public void undo() {
        if (this.oldSize != null && this.target != null) {
            final Size temp = this.target.getSize();
            this.target.setSize(oldSize);
            this.oldSize = temp;
        }
    }

    @Override
    public void redo() {
        this.undo();
    }

    @Override
    public String toString() {
        return "Shrink spell";
    }
}
