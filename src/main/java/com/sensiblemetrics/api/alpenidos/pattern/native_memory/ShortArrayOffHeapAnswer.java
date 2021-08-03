package com.sensiblemetrics.api.alpenidos.pattern.native_memory;

import sun.misc.Unsafe;

class ShortArrayOffHeapAnswer implements ShortArrayOffHeap {

    private final long size;
    private final long startAddress;
    private final short SHORT_LENGTH_IN_BYTES = 2;

    private final Unsafe unsafe = UnsafeUtils.createUnsafe();

    public ShortArrayOffHeapAnswer(long size) {
        this.size = size;
        startAddress = unsafe.allocateMemory(allocationSize());
        initWithZeros();
    }

    @Override
    public void putShortAt(long index, short value) {
        verifyIndexNotExceedsSize(index);
        unsafe.putShort(addressOf(index), value);
    }

    @Override
    public short getShortAt(long index) {
        verifyIndexNotExceedsSize(index);
        return unsafe.getShort(addressOf(index));
    }

    @Override
    public void destroy() {
        unsafe.freeMemory(startAddress);
    }

    private long addressOf(long index) {
        return startAddress + (index * SHORT_LENGTH_IN_BYTES);
    }

    private void initWithZeros() {
        unsafe.setMemory(startAddress, allocationSize(), (byte) 0);
    }

    private long allocationSize() {
        return size * SHORT_LENGTH_IN_BYTES;
    }

    private void verifyIndexNotExceedsSize(long index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
