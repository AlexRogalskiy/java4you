package com.sensiblemetrics.api.alpenidos.pattern.nio.handler;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

class Step2_ClientConnectionAnswer {

    private final Step1_PendingMessagesAnswer pendingMessages;

    Step2_ClientConnectionAnswer(Step1_PendingMessagesAnswer pendingMessages) {
        this.pendingMessages = pendingMessages;
    }

    void tryAccept(SelectionKey key) throws IOException {
        if (canBeAccepted(key)) {
            ServerSocketChannel channel = (ServerSocketChannel) key.channel();
            SocketChannel client = channel.accept(); // never null, nonblocking
            log("Client connected: " + client);
            client.configureBlocking(false);
            pendingMessages.initFor(client);
            client.register(key.selector(), SelectionKey.OP_READ);
        }
    }

    private boolean canBeAccepted(SelectionKey key) {
        return key.isValid() && key.isAcceptable();
    }

    private void log(String message) {
        System.out.println(message);
    }
}
