package com.sensiblemetrics.api.alpenidos.pattern.nio.server;

import com.sensiblemetrics.api.alpenidos.pattern.nio.handler.Step7_SingleThreadedEventLoopAnswer;
import java.io.IOException;
import java.nio.channels.Selector;

public class Step10_SingleThreadedServerAnswer extends Step9_ServerAnswer {

    public Step10_SingleThreadedServerAnswer(int port) {
        super(port);
    }

    @Override
    protected void handleConnections(Selector selector) throws IOException {
        new Step7_SingleThreadedEventLoopAnswer().runOver(selector);
    }

    public static void main(String[] args) throws IOException {
        new Step10_SingleThreadedServerAnswer(81).start();
    }
}
