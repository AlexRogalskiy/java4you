package com.sensiblemetrics.api.alpenidos.pattern.nio2;

import static java.util.Objects.nonNull;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Optional;

/**
 * Created by mtumilowicz on 2019-07-21.
 */
public class Step5_ServerAnswer extends Step4_NonBlockingServerAnswer {

    public Step5_ServerAnswer(int port) {
        super(port);
    }

    public static void main(final String[] args) throws IOException {
        new Step5_ServerAnswer(81).start();
    }

    @Override
    protected void processSockets(final ServerSocketChannel ssc) throws IOException {
        var clients = new Step3_ClientsAnswer();
        while (true) {
            this.acceptConnection(ssc).ifPresent(clients::add);
            clients.handleConnected();
            clients.removeNotConnected();
        }
    }

    private Optional<SocketChannel> acceptConnection(final ServerSocketChannel ssc) throws IOException {
        SocketChannel newSocket = ssc.accept();
        if (nonNull(newSocket)) {
            log("Connected to " + newSocket);
            newSocket.configureBlocking(false);
        }

        return Optional.ofNullable(newSocket);
    }

    private void log(String message) {
        System.out.println(message);
    }
}
