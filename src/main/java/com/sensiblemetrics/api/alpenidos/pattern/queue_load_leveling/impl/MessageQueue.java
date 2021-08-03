package com.sensiblemetrics.api.alpenidos.pattern.queue_load_leveling.impl;

import com.sensiblemetrics.api.alpenidos.pattern.queue_load_leveling.model.Message;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * MessageQueue class.
 * In this class we will create a Blocking Queue and
 * submit/retrieve all the messages from it.
 */
@Slf4j
public class MessageQueue {
    private final BlockingQueue<Message> blkQueue;

    // Default constructor when called creates Blocking Queue object.
    public MessageQueue() {
        this.blkQueue = new ArrayBlockingQueue<Message>(1024);
    }

    /**
     * All the TaskGenerator threads will call this method to insert the
     * Messages in to the Blocking Queue.
     */
    public void submitMsg(final Message msg) {
        try {
            if (null != msg) {
                this.blkQueue.add(msg);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * All the messages will be retrieved by the ServiceExecutor by
     * calling this method and process them.
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     */
    public Message retrieveMsg() {
        Message retrievedMsg = null;
        try {
            retrievedMsg = blkQueue.poll();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return retrievedMsg;
    }
}
