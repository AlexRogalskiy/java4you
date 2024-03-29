package com.sensiblemetrics.api.alpenidos.pattern.singleton2;

public class Messenger {

    private static final Object lock = new Object();
    private static volatile Messenger messenger;

    private Messenger() {
    }

    public static Messenger getInstance() {

        if (messenger == null) {
            synchronized (lock) {
                if (messenger == null) {
                    messenger = new Messenger();
                }
            }
        }

        return messenger;
    }

    public void send(String message) {
    }
}
