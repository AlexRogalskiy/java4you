package com.sensiblemetrics.api.alpenidos.core.concurrency.mutex2;

public class MutexExample {

    public static void main(final String[] args) {
        final Mutex lock = new Mutex();

        // The bank can only be accessed by one theif at a time
        final Bank bank = new Bank(100, lock);
        final Theif theifA = new Theif("Alice");
        final Theif theifB = new Theif("Bob");

        theifA.rob(bank);
        theifB.rob(bank);
        theifA.start();
        theifB.start();
    }
}
