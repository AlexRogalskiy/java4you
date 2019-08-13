package com.sensiblemetrics.api.alpenidos.core.command5.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EOperator {
    ADD("+", "-"),
    MINUS("-", "+"),
    MUTIPLE("*", "/"),
    DIVIDE("/", "*"),
    UNKNOW("", "");

    private final String operator;
    private final String undoOperator;

    public static EOperator queryOperator(final String operator) {
        final EOperator[] values = EOperator.values();
        for (final EOperator op : values) {
            if (op.getOperator().equals(operator)) {
                return op;
            }
        }
        return UNKNOW;
    }
}
