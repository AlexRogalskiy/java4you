package com.sensiblemetrics.api.alpenidos.core.command5.service;

import com.sensiblemetrics.api.alpenidos.core.command5.model.Command;
import com.sensiblemetrics.api.alpenidos.core.command5.model.ElementaryArithCommand;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CalculationInvokerImpl implements CalculationInvoker {
    private List<Command> commands = new LinkedList<>();

    public void compute(final Object receiver, final String operator, final int operand) {
        // Create command operation and execute it
        final Command command = new ElementaryArithCommand(receiver, operator, operand);
        command.execute();
        this.commands.add(command);
    }

    public void undo() {
        int size = this.commands.size();
        if (size > 0) {
            final Command command = this.commands.get(size - 1);
            command.unExecute();
            this.commands.remove(size - 1);
        }
    }
}
