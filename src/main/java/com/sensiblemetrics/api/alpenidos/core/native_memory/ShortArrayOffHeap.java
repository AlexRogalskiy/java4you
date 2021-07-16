package com.sensiblemetrics.api.alpenidos.core.native_memory;

public interface ShortArrayOffHeap {

    void putShortAt(long index, short value);

    short getShortAt(long index);

    void destroy();
}
