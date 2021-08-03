package com.sensiblemetrics.api.alpenidos.pattern.concurrent.sharedstate;

import com.sensiblemetrics.api.alpenidos.pattern.annotation.GuardedBy;
import com.sensiblemetrics.api.alpenidos.pattern.annotation.ThreadSafe;

import java.util.concurrent.Executors;

/**
 * Pattern: Protected Shared State
 * <p>
 * Example: A simple Counter example.
 */
@ThreadSafe
public class VisitCounter {

    @GuardedBy("this")
    private int value;

    public synchronized int actualValue() {
        return this.value;
    }

    public synchronized void increase() {
        this.value++;
    }

    public synchronized void decrease() {
        this.value--;
    }

    public static void main(String[] args) {
        var counter = new VisitCounter();
        var threadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 50; i++) {
            System.out.println("value " + counter.actualValue() + " i " + i);
            threadPool.execute(() -> counter.increase());
        }
        threadPool.shutdown();
        System.out.println(counter.actualValue());
    }
}
