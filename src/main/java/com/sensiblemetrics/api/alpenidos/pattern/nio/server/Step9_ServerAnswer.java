package com.sensiblemetrics.api.alpenidos.pattern.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by mtumilowicz on 2019-07-31.
 */
public abstract class Step9_ServerAnswer {

    protected final int port;

    public Step9_ServerAnswer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        log("Creating server socket on port " + port);
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("localhost", port));
        ssc.configureBlocking(false);
        log("Created server socket on port " + port);

        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        handleConnections(selector);
    }

    protected abstract void handleConnections(Selector selector) throws IOException;

    private void log(String message) {
        System.out.println(message);
    }
}
