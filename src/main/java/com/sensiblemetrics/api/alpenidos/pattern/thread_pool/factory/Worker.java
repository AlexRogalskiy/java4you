package com.sensiblemetrics.api.alpenidos.pattern.thread_pool.factory;

import com.sensiblemetrics.api.alpenidos.pattern.thread_pool.impl.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Worker implements {@link Runnable} and thus can be executed by {@link java.util.concurrent.ExecutorService}
 */
@Slf4j
@RequiredArgsConstructor
public class Worker implements Runnable {
    private final Task task;

    @Override
    public void run() {
        log.info("{} processing {}", Thread.currentThread().getName(), this.task.toString());
        try {
            Thread.sleep(this.task.getTimeMs());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
