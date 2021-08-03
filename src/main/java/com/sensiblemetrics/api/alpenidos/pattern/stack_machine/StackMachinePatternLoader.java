package com.sensiblemetrics.api.alpenidos.pattern.stack_machine;

import com.sensiblemetrics.api.alpenidos.pattern.stack_machine.constants.OperationConstants;
import com.sensiblemetrics.api.alpenidos.pattern.stack_machine.exception.AddressOutOfBoundsException;
import com.sensiblemetrics.api.alpenidos.pattern.stack_machine.exception.InvalidParametersException;
import com.sensiblemetrics.api.alpenidos.pattern.stack_machine.impl.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class StackMachinePatternLoader {

    public static void main(final String[] args) {
		/*
		0x0: 		in	  		// read a value value from IO and push it to exp-stack
		0x1: 		call 0x5		// call the subroutine at @ of label named "fact"
		0x3: 		out			// pop a value from exp-stack and print it via IO
		0x4: 		halt			// stop the program
		0x5: (fact) dup			// dup the value on top of exp-stack
		0x6: 		jz 0xb		// pop a value from exp-stack and jump if zero to @ of label named "end"
		0x8: 		call 0xf	 	// call the subroutine at @ of label named "rec"
		0xa:        ret			// return from subroutine call
		0xb: (end)	pop			// pop a value from exp-stack (and drop it)
		0xc:			push 0x1    // push a value (0x1) on exp-stack
		0xe			ret			// return
		0xf: (rec)	dup			// duplicate value on top of exp-stack
		0x10			push 0x1    // push a value (0x1) on exp-stack
		0x12			sub			// pop 2 values from exp-stack, substract the first to the second, push result on exp-stack
		0x13			call 0x5		// call the subroutine at @ of label named "fact"
		0x15			mul			// pop 2 values from exp-stack, multiply them, push result on exp-stack
		0x16			ret			// return
		*/
        Instruction[] instructions =
            new Instruction[]
                {
                    new Instruction(OperationConstants.IN, null),
                    new Instruction(OperationConstants.CALL, new int[]{0x5}),
                    new Instruction(OperationConstants.OUT, null),
                    new Instruction(OperationConstants.HALT, null),
                    new Instruction(OperationConstants.DUP, null),
                    new Instruction(OperationConstants.JZ, new int[]{0xb}),
                    new Instruction(OperationConstants.CALL, new int[]{0xf}),
                    new Instruction(OperationConstants.RET, null),
                    new Instruction(OperationConstants.POP, null),
                    new Instruction(OperationConstants.PUSH, new int[]{0x1}),
                    new Instruction(OperationConstants.RET, null),
                    new Instruction(OperationConstants.DUP, null),
                    new Instruction(OperationConstants.PUSH, new int[]{0x1}),
                    new Instruction(OperationConstants.SUB, null),
                    new Instruction(OperationConstants.CALL, new int[]{0x5}),
                    new Instruction(OperationConstants.MUL, null),
                    new Instruction(OperationConstants.RET, null)
                };
        final Program program = new Program(instructions);

        Memory programMemory = null;
        Stack<Instruction> expStack = null;
        Stack<Instruction> callStack = null;

        int startAddress = 0x00000000;
        int endAddress = 0x00000020;
        int loadAddress = 0x00000000;
        int stackSize = 16;
        try {
            programMemory = new Memory(startAddress, endAddress);
            expStack = new Stack();
            expStack.setSize(stackSize);
            callStack = new Stack();
            callStack.setSize(stackSize);
        } catch (InvalidParametersException e) {
            // Safely ignore this error, which is not one
        }

        final IO ioSystem = new IO(System.in, System.out, System.err);
        final CPU cpu = new CPU();
        final Machine machine = new Machine(cpu, programMemory, expStack, callStack, ioSystem);
        try {
            machine.loadProgram(program, loadAddress);
        } catch (AddressOutOfBoundsException e) {
            log.error("Program loading failure: program does not fit memory");
            System.exit(1);
        }
        machine.executeProgram(loadAddress);
    }
}
