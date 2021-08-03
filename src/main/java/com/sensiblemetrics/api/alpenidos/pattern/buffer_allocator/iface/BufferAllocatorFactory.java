package com.sensiblemetrics.api.alpenidos.pattern.buffer_allocator.iface;

public interface BufferAllocatorFactory {

    BufferAllocator getBufferAllocator(final int minSize);
}
