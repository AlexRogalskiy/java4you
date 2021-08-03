package com.sensiblemetrics.api.alpenidos.pattern.object_pool.factory;

import com.sensiblemetrics.api.alpenidos.pattern.object_pool.iface.Resource;
import com.sensiblemetrics.api.alpenidos.pattern.object_pool.iface.ResourceFactory;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

@RequiredArgsConstructor
public class ResourcePoolFactory implements ResourceFactory {
    private final ResourceFactory resourceFactory;

    private final Queue<Resource> pool = new LinkedList<>();

    @Override
    public Resource get() {
        if (this.pool.isEmpty()) {
            return new PoolResource(this.resourceFactory.get());
        }
        return this.pool.poll();
    }

    @RequiredArgsConstructor
    public class PoolResource implements Resource {
        private final Resource resource;

        @Override
        public void print() {
            this.resource.print();
        }

        @Override
        public void close() {
            pool.add(this);
        }
    }
}
