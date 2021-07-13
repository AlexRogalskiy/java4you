package com.sensiblemetrics.api.alpenidos.core.concurrency.mutex2;

public class Bank {

    private int money;
    private final Mutex lock;

    public Bank(int money, Mutex lock) {
        this.money = money;
        this.lock = lock;
    }

    public void withdrawl(int i) {
        try {
            lock.acquire();
            money -= i;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.release();
        }
    }

    public boolean isEmpty() {
        return money == 0;
    }
}
