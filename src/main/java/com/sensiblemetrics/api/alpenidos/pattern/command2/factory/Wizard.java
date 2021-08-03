package com.sensiblemetrics.api.alpenidos.pattern.command2.factory;

import com.sensiblemetrics.api.alpenidos.pattern.command2.impl.Command;
import com.sensiblemetrics.api.alpenidos.pattern.command2.model.Target;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Wizard is the invoker of the commands
 */
@Slf4j
@NoArgsConstructor
public class Wizard {
    private Deque<Command> undoStack = new LinkedList<>();
    private Deque<Command> redoStack = new LinkedList<>();

    /**
     * Cast spell
     */
    public void castSpell(final Command command, final Target target) {
        log.info("{} casts {} at {}", this, command, target);
        command.execute(target);
        this.undoStack.offerLast(command);
    }

    /**
     * Undo last spell
     */
    public void undoLastSpell() {
        if (!this.undoStack.isEmpty()) {
            final Command previousSpell = this.undoStack.pollLast();
            this.redoStack.offerLast(previousSpell);
            log.info("{} undoes {}", this, previousSpell);
            previousSpell.undo();
        }
    }

    /**
     * Redo last spell
     */
    public void redoLastSpell() {
        if (!this.redoStack.isEmpty()) {
            final Command previousSpell = this.redoStack.pollLast();
            this.undoStack.offerLast(previousSpell);
            log.info("{} redoes {}", this, previousSpell);
            previousSpell.redo();
        }
    }

    @Override
    public String toString() {
        return "Wizard";
    }
}
