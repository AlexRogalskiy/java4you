package com.sensiblemetrics.api.alpenidos.pattern.queue_load_leveling.impl;

import com.sensiblemetrics.api.alpenidos.pattern.queue_load_leveling.iface.Task;
import com.sensiblemetrics.api.alpenidos.pattern.queue_load_leveling.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * TaskGenerator class.
 * Each TaskGenerator thread will be a Worker which submit's messages to the queue.
 * We need to mention the message count for each of the TaskGenerator threads.
 */
@Slf4j
@RequiredArgsConstructor
public class TaskGenerator implements Task, Runnable {
    // MessageQueue reference using which we will submit our messages.
    private final MessageQueue msgQueue;
    // Total message count that a TaskGenerator will submit.
    private final int msgCount;

    /**
     * Submit messages to the Blocking Queue.
     */
    @Override
    public void submit(final Message msg) {
        try {
            this.msgQueue.submitMsg(msg);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Each TaskGenerator thread will submit all the messages to the Queue.
     * After every message submission TaskGenerator thread will sleep for 1 second.
     */
    @Override
    public void run() {
        int count = this.msgCount;
        try {
            while (count > 0) {
                final String statusMsg = "Message-" + count + " submitted by " + Thread.currentThread().getName();
                this.submit(new Message(statusMsg));
                log.info(statusMsg);
                // reduce the message count.
                count--;
                // Make the current thread to sleep after every Message submission.
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
