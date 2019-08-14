package com.sensiblemetrics.api.alpenidos.core.buffer_allocator.iface;

/**
 * BufferAllocator interface. The implementation of this interface must be thread-safe
 */
public interface BufferAllocator {

    byte[] allocate(final int size);

    void release(final byte[] buffer);
}
