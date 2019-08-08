package com.sensiblemetrics.api.alpenidos.core.semaphore2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Mutex {

    /**
     * This is the resource you want to limit access to
     */
    private static int n;

    public static Semaphore semaphore;

    public static void main(final String[] args) {
        new Mutex();

        final MutexThread a = new MutexThread(10, MutexThread.TYPE_A);
        final MutexThread b = new MutexThread(10, MutexThread.TYPE_B);

        //This starts the two threads randomly every time you run the program
        final int order = (int) (Math.random() * 100) % 2;

        if (order == 0) {
            log.info("A starts");
            a.start();
            b.start();
        } else {
            log.info("B starts");
            b.start();
            a.start();
        }
    }

    public Mutex() {
        n = 0;
        semaphore = new Semaphore(1); //A mutex semaphore always has a count of 1
    }

    //Methods a and b operate the variable in different ways

    public static void a() {
        n += 1000;
        try {
            log.info("Counter: " + n);
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void b() {
        n++;
        try {
            log.info("Counter: " + n);
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
