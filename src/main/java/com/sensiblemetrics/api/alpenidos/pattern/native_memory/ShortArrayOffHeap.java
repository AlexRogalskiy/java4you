package com.sensiblemetrics.api.alpenidos.pattern.native_memory;

public interface ShortArrayOffHeap {

    void putShortAt(long index, short value);

    short getShortAt(long index);

    void destroy();
}
