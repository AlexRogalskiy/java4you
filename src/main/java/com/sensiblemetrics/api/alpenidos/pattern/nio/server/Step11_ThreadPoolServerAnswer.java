package com.sensiblemetrics.api.alpenidos.pattern.nio.server;

import com.sensiblemetrics.api.alpenidos.pattern.nio.handler.Step8_ThreadPooledEventLoopAnswer;
import java.io.IOException;
import java.nio.channels.Selector;

public class Step11_ThreadPoolServerAnswer extends Step9_ServerAnswer {

    public Step11_ThreadPoolServerAnswer(int port) {
        super(port);
    }

    @Override
    protected void handleConnections(Selector selector) throws IOException {
        new Step8_ThreadPooledEventLoopAnswer().runOver(selector);
    }

    public static void main(String[] args) throws IOException {
        new Step11_ThreadPoolServerAnswer(81).start();
    }
}
