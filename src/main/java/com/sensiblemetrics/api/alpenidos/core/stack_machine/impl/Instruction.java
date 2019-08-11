package com.sensiblemetrics.api.alpenidos.core.stack_machine.impl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Instruction {
    private final int in;
    private final int[] value;

    public int getOpCode() {
        return this.in;
    }

    public int[] getParams() {
        return this.value;
    }
}
