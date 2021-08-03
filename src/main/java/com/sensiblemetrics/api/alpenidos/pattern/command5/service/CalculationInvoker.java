package com.sensiblemetrics.api.alpenidos.pattern.command5.service;

public interface CalculationInvoker {

    void compute(final Object receiver, final String operator, final int operand);

    void undo();
}
