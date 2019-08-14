package com.sensiblemetrics.api.alpenidos.core.buffer_allocator.iface;

public interface BufferAllocatorFactory {

    BufferAllocator getBufferAllocator(final int minSize);
}
