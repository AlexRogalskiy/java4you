package com.sensiblemetrics.api.alpenidos.pattern.task_cancel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Pattern: Thread Task Cancel
 * <p>
 * Example: Canceling a Background Timer Print Task.
 */
public class TaskCancelPatternLoader {

    private Thread thread;
    private Runnable task = () -> {
        while (!Thread.currentThread().isInterrupted()) {
            var date = new Date(System.currentTimeMillis());
            System.out.println(new SimpleDateFormat().format(date));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // no need to interrupt() if you don't have anything throwing InterruptedException
                thread.interrupt();
            }
        }
    };

    public void run() {
        thread = new Thread(task);
        thread.start();
    }

    public void cancel() {
        if (thread != null) {
            thread.interrupt();
        }
    }

    public static void main(String[] args) {
        var self = new TaskCancelPatternLoader();
        self.run();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        self.cancel();
    }
}
