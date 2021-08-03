package com.sensiblemetrics.api.alpenidos.pattern.nio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by mtumilowicz on 2019-07-31.
 */
public abstract class Step4_NonBlockingServerAnswer {

    protected final int port;

    public Step4_NonBlockingServerAnswer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        log("Creating server socket on port " + port);

        final ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("localhost", port));
        ssc.configureBlocking(false);

        log("Created server socket on port " + port);

        this.processSockets(ssc);
    }

    protected abstract void processSockets(final ServerSocketChannel ssc) throws IOException;

    private void log(final String message) {
        System.out.println(message);
    }
}
