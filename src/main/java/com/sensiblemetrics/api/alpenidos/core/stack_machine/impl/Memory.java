package com.sensiblemetrics.api.alpenidos.core.stack_machine.impl;

import com.sensiblemetrics.api.alpenidos.core.utils.ValidationUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class Memory {
    private final int startAddress;
    private final int endAddress;
    private final int[] memoryHeap;

    public Memory(final int startAddress, final int endAddress) {
        ValidationUtils.isTrue(startAddress >= 0, "Start address should not be negative");
        ValidationUtils.isTrue(endAddress >= 0, "End address should not be negative");
        ValidationUtils.isTrue(endAddress >= startAddress, "End address should be greater than start address");

        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.memoryHeap = new int[this.endAddress - this.startAddress];
    }

    public void write(final int currentAddress, final int opCode) {
        this.memoryHeap[currentAddress] = opCode;
    }
}
