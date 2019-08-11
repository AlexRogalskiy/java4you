package com.sensiblemetrics.api.alpenidos.core.stack_machine.impl;

import com.sensiblemetrics.api.alpenidos.core.stack_machine.exception.AddressOutOfBoundsException;
import lombok.Data;

import java.util.Stack;

@Data
public class Machine {
    private CPU cpu;
    private Memory programMemory;

    public Machine(final CPU cpu, final Memory programMemory, final Stack<Instruction> expStack, final Stack<Instruction> callStack, final IO ioSystem) {
        this.cpu = cpu;
        this.programMemory = programMemory;
        this.cpu.wireToProgramMemory(programMemory);
        this.cpu.wireToExpStack(expStack);
        this.cpu.wireToCallStack(callStack);
        this.cpu.wireToIoSubsystem(ioSystem);
    }

    public void loadProgram(final Program program, final int loadAddress) throws AddressOutOfBoundsException {
        int currentAddress = loadAddress;

        for (int instructionNumber = 0; instructionNumber < program.getInstructionCount(); instructionNumber++) {
            Instruction instruction = program.getInstructionAt(instructionNumber);
            this.programMemory.write(currentAddress, instruction.getOpCode());
            currentAddress++;
            int[] instructionParams = instruction.getParams();
            if (instructionParams != null) {
                for (int instructionParam : instructionParams) {
                    this.programMemory.write(currentAddress, instructionParam);
                    currentAddress++;
                }
            }
        }
    }

    public void executeProgram(int loadAddress) {
        this.cpu.clearStacks();
        this.cpu.setPC(loadAddress);
        this.cpu.run();
        System.out.println("(end of program execution)");
    }
}
