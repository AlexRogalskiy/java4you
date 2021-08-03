package com.sensiblemetrics.api.alpenidos.pattern.queue_load_leveling.service;

import com.sensiblemetrics.api.alpenidos.pattern.queue_load_leveling.impl.MessageQueue;
import com.sensiblemetrics.api.alpenidos.pattern.queue_load_leveling.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ServiceExecuotr class.
 * This class will pick up Messages one by one from
 * the Blocking Queue and process them.
 */
@Slf4j
@RequiredArgsConstructor
public class ServiceExecutor implements Runnable {
    private final MessageQueue msgQueue;

    /**
     * The ServiceExecutor thread will retrieve each message and process it.
     */
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                final Message msg = this.msgQueue.retrieveMsg();
                if (null != msg) {
                    log.info(msg.toString() + " is served.");
                } else {
                    log.info("Service Executor: Waiting for Messages to serve .. ");
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
