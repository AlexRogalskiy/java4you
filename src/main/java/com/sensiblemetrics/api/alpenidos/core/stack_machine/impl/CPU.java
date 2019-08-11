package com.sensiblemetrics.api.alpenidos.core.stack_machine.impl;

import com.sensiblemetrics.api.alpenidos.core.stack_machine.exception.AddressOutOfBoundsException;
import com.sensiblemetrics.api.alpenidos.core.stack_machine.exception.StackOverflowException;
import com.sensiblemetrics.api.alpenidos.core.stack_machine.exception.StackUnderflowException;

import java.util.Stack;

import static com.sensiblemetrics.api.alpenidos.core.stack_machine.constants.OperationConstants.*;

public class CPU {
    private IO ioSystem;
    private int loadAddress;

    public void run() {
        try {
            while (true) {
                switch (this.loadAddress) {
                    case HALT: {
                        // System.err.println("HALT");
                        this.ioSystem.displayProgramTermination();
                        return;
                    }
                    case PUSH: {
                        // TODO something is missing here...
                        break;
                    }
                    case ADD: {
                        // TODO something is missing here...
                        break;
                    }
                    case SUB: {
                        // TODO something is missing here...
                        break;
                    }
                    case MUL: {
                        // TODO something is missing here...
                        break;
                    }
                    case DIV: {
                        // TODO something is missing here...
                        break;
                    }
                    case MOD: {
                        // TODO something is missing here...
                        break;
                    }
                    case NEG: {
                        // TODO something is missing here...
                        break;
                    }
                    case LT: {
                        // TODO something is missing here...
                        break;
                    }
                    case LE: {
                        // TODO something is missing here...
                        break;
                    }
                    case GT: {
                        // TODO something is missing here...
                        break;
                    }
                    case GE: {
                        // TODO something is missing here...
                        break;
                    }
                    case EQ: {
                        // TODO something is missing here...
                        break;
                    }
                    case NE: {
                        // TODO something is missing here...
                        break;
                    }
                    case IN: {
                        // TODO something is missing here...
                        break;
                    }
                    case OUT: {
                        // TODO something is missing here...
                        break;
                    }
                    case CALL: {
                        // TODO something is missing here...
                        break;
                    }
                    case RET: {
                        // TODO something is missing here...
                        break;
                    }
                    case JP: {
                        // TODO something is missing here...
                        break;
                    }
                    case JZ: {
                        // TODO something is missing here...
                        break;
                    }
                    case DUP: {
                        // TODO something is missing here...
                        break;
                    }
                    case POP: {
                        // TODO something is missing here...
                        break;
                    }
                    default: {
                        // TODO something is missing here...
                        return;
                    }
                }
            }
        } catch (AddressOutOfBoundsException e) {
            // TODO something is missing here...
        } catch (StackOverflowException e) {
            // TODO something is missing here...
        } catch (StackUnderflowException e) {
            // TODO something is missing here...
        }
    }

    public void wireToProgramMemory(final Memory programMemory) {
    }

    public void wireToExpStack(final Stack<Instruction> expStack) {
    }

    public void wireToCallStack(final Stack<Instruction> callStack) {
    }

    public void wireToIoSubsystem(final IO ioSystem) {
        this.ioSystem = ioSystem;
    }

    public void clearStacks() {
    }

    public void setPC(final int loadAddress) {
        this.loadAddress = loadAddress;
    }
}
