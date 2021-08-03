package com.sensiblemetrics.api.alpenidos.pattern.stack_machine.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class OperationConstants {
    public final static int HALT = 0x00;
    public final static int PUSH = 0x01;
    public final static int ADD = 0x02;
    public final static int SUB = 0x03;
    public final static int MUL = 0x04;
    public final static int DIV = 0x05;
    public final static int MOD = 0x06;
    public final static int NEG = 0x07;
    public final static int LT = 0x08;
    public final static int LE = 0x09;
    public final static int GT = 0x0A;
    public final static int GE = 0x0B;
    public final static int EQ = 0x0C;
    public final static int NE = 0x0D;
    public final static int IN = 0x0E;
    public final static int OUT = 0x0F;
    public final static int CALL = 0x10;
    public final static int RET = 0x11;
    public final static int JP = 0x12;
    public final static int JZ = 0x13;
    public final static int DUP = 0x14;
    public final static int POP = 0x15;
}
