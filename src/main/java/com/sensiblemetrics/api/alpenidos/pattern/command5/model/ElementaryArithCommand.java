package com.sensiblemetrics.api.alpenidos.pattern.command5.model;

import com.sensiblemetrics.api.alpenidos.pattern.command5.service.ElementaryArithCalculator;
import com.sensiblemetrics.api.alpenidos.pattern.command5.enums.EOperator;

public final class ElementaryArithCommand extends Command {
    private ElementaryArithCalculator _caculator;

    public ElementaryArithCommand(final Object receiver, final String operator, final int operand) {
        super(receiver, EOperator.queryOperator(operator), operand);
        if (receiver instanceof ElementaryArithCalculator)
            this._caculator = (ElementaryArithCalculator) receiver;
    }

    @Override
    public void execute() {
        if (this._caculator != null)
            this._caculator.operation(this.operator.getOperator(), this.operand);
    }

    @Override
    public void unExecute() {
        if (this._caculator != null)
            this._caculator.operation(this.operator.getUndoOperator(), this.operand);
    }
}
