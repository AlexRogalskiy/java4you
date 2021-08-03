package com.sensiblemetrics.api.alpenidos.pattern.stack_machine.impl;

import com.sensiblemetrics.api.alpenidos.pattern.utils.ValidationUtils;

public class Program {
    private final Instruction[] instructions;

    public Program(final Instruction[] instructions) {
        ValidationUtils.notNull(instructions, "Instructions should not be null");
        this.instructions = instructions;
    }

    public Instruction getInstructionAt(final int instructionNumber) {
        ValidationUtils.isTrue(this.checkRange(instructionNumber), "Instruction number is out of instruction range");
        return this.instructions[instructionNumber];
    }

    public int getInstructionCount() {
        return this.instructions.length;
    }

    private boolean checkRange(final int instructionNumber) {
        return (instructionNumber >= 0 && instructionNumber <= this.instructions.length);
    }
}
