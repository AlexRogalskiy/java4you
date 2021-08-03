package com.sensiblemetrics.api.alpenidos.pattern.semaphore2;

public class MultiplexThread extends Thread {

    public void run() {
        //Before calling the method, the thread acquires the permit, after calling it, it releases it.
        Multiplex.semaphore.acquire();
        Multiplex.a();
        Multiplex.semaphore.release();
    }
}
