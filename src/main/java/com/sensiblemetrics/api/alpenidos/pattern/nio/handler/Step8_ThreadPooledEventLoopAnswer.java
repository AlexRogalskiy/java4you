package com.sensiblemetrics.api.alpenidos.pattern.nio.handler;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mtumilowicz on 2019-07-30.
 */
public class Step8_ThreadPooledEventLoopAnswer {

    private final ExecutorService pool = Executors.newFixedThreadPool(10);
    private final Step1_PendingMessagesAnswer pendingMessages = new Step1_PendingMessagesAnswer();
    private final Queue<Runnable> switchKeysToWriteActions = new ConcurrentLinkedQueue<>();
    private final Step2_ClientConnectionAnswer clientConnection = new Step2_ClientConnectionAnswer(pendingMessages);
    private final Step6_ThreadPooledIncomingMessageAnswer incomingMessage = new Step6_ThreadPooledIncomingMessageAnswer(pool, pendingMessages,
        switchKeysToWriteActions);
    private final Step3_OutgoingMessageAnswer outgoingMessage = new Step3_OutgoingMessageAnswer(pendingMessages);

    public void runOver(Selector selector) throws IOException {
        while (true) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            switchKeysToWriteAndClear();
            keys.forEach(this::runOperationOf);
            keys.clear();
        }
    }

    private void switchKeysToWriteAndClear() {
        switchKeysToWriteActions.forEach(Runnable::run);
        switchKeysToWriteActions.clear();
    }

    private void runOperationOf(SelectionKey key) {
        try {
            clientConnection.tryAccept(key);
            incomingMessage.tryReceive(key);
            outgoingMessage.trySend(key);
        } catch (Exception ex) {
            // workshops
        }
    }
}
