package com.sensiblemetrics.api.alpenidos.pattern.semaphore2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MutexThread extends Thread {
    private final int times;
    private final int type;

    public final static int TYPE_A = 1;
    public final static int TYPE_B = 0;

    public void run() {
        if (this.type == TYPE_A) {
            for (int i = 0; i < this.times; i++) {
                Mutex.semaphore.acquire();
                Mutex.a();
                Mutex.semaphore.release();
            }
        }
        if (type == TYPE_B) {
            for (int i = 0; i < this.times; i++) {
                Mutex.semaphore.acquire();
                Mutex.b();
                Mutex.semaphore.release();
            }
        }
    }
}
