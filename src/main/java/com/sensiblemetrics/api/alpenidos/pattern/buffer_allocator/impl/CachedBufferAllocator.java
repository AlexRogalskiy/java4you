package com.sensiblemetrics.api.alpenidos.pattern.buffer_allocator.impl;

import com.sensiblemetrics.api.alpenidos.pattern.buffer_allocator.iface.BufferAllocator;
import com.sensiblemetrics.api.alpenidos.pattern.buffer_allocator.iface.BufferAllocatorFactory;

import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Cached buffer
 */
public class CachedBufferAllocator implements BufferAllocator {

    private static BufferAllocatorFactory factory = bufferSize -> CachedBufferAllocator.getAllocator(bufferSize);

    public static void setBufferAllocatorFactory(BufferAllocatorFactory factory) {
        assert (factory != null);
        CachedBufferAllocator.factory = factory;
    }

    public static BufferAllocatorFactory getBufferAllocatorFactory() {
        return factory;
    }

    /**
     * Use SoftReference so that having this queueTable does not prevent the GC of CachedBufferAllocator instances
     */
    private static final Map<Integer, SoftReference<CachedBufferAllocator>> queueTable = new HashMap<>();

    private final int bufferSize;
    private final Deque<byte[]> bufferQueue;

    public CachedBufferAllocator(int bufferSize) {
        this.bufferSize = bufferSize;
        this.bufferQueue = new ArrayDeque<>();
    }

    public static synchronized CachedBufferAllocator getAllocator(final int bufferSize) {
        CachedBufferAllocator result = null;
        if (queueTable.containsKey(bufferSize)) {
            result = queueTable.get(bufferSize).get();
        }
        if (result == null) {
            result = new CachedBufferAllocator(bufferSize);
            queueTable.put(bufferSize, new SoftReference<CachedBufferAllocator>(result));
        }
        return result;
    }

    @Override
    public byte[] allocate(final int size) {
        synchronized (this) {
            if (this.bufferQueue.isEmpty()) {
                return new byte[size];
            } else {
                return this.bufferQueue.pollFirst();
            }
        }
    }

    @Override
    public void release(final byte[] buffer) {
        synchronized (this) {
            this.bufferQueue.addLast(buffer);
        }
    }
}
