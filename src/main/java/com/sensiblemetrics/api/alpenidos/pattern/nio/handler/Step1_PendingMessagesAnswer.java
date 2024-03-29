package com.sensiblemetrics.api.alpenidos.pattern.nio.handler;

import com.sensiblemetrics.api.alpenidos.pattern.nio.transformer.BufferTransformer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.UnaryOperator;

class Step1_PendingMessagesAnswer {

    private final Map<SocketChannel, Queue<ByteBuffer>> pendingMessagesByClient = new ConcurrentHashMap<>();

    void initFor(SocketChannel client) {
        pendingMessagesByClient.put(client, new ConcurrentLinkedQueue<>());
    }

    void sendTo(SocketChannel client) throws IOException {
        var buffersToWrite = pendingMessagesByClient.get(client);
        while (!buffersToWrite.isEmpty()) {
            client.write(buffersToWrite.poll());
        }
    }

    void closeClientIfEnd(SocketChannel client) throws IOException {
        pendingMessagesByClient.remove(client);
        client.close();
    }

    void prepareForSendingTo(SocketChannel client, ByteBuffer buffer) {
        prepareBuffer(buffer);
        pendingMessagesByClient.get(client).add(buffer);
    }

    private void prepareBuffer(ByteBuffer buf) {
        buf.flip();
        BufferTransformer.transformBytes(buf, UnaryOperator.identity());
    }
}
