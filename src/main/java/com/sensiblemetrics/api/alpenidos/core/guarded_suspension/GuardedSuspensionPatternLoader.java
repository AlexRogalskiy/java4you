package com.sensiblemetrics.api.alpenidos.core.guarded_suspension;

import com.sensiblemetrics.api.alpenidos.core.guarded_suspension.impl.GuardedQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GuardedSuspensionPatternLoader {

    /**
     * Example pattern execution
     *
     * @param args - command line args
     */
    public static void main(final String[] args) {
        final GuardedQueue guardedQueue = new GuardedQueue();
        final ExecutorService executorService = Executors.newFixedThreadPool(3);

        //here we create first thread which is supposed to get from guardedQueue
        executorService.execute(() -> {
                guardedQueue.get();
            }
        );

        //here we wait two seconds to show that the thread which is trying to get from guardedQueue will be waiting
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //now we execute second thread which will put number to guardedQueue and notify first thread that it could get
        executorService.execute(() -> {
                guardedQueue.put(20);
            }
        );

        executorService.shutdown();
        try {
            executorService.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
