package com.sensiblemetrics.api.alpenidos.pattern.semaphore2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Multiplex {

    public static Semaphore semaphore;

    public static void main(final String args[]) {
        new Multiplex();

        final MultiplexThread[] threads = new MultiplexThread[50];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MultiplexThread();
        }
        for (final MultiplexThread thread : threads) {
            thread.start();
        }
    }

    public Multiplex() {
        //This semaphore ensures that a maximum of three threads are using the resource at the same time
        semaphore = new Semaphore(3);
    }

    /**
     * You want to limit access to this method with the semaphore
     */
    public static void a() {
        try {
            log.info("calling a");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
