package com.sensiblemetrics.api.alpenidos.core.nio2;

import static java.util.function.Predicate.not;

import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

class Step3_ClientsAnswer {

    private final List<SocketChannel> clients = new ArrayList<>();

    void add(SocketChannel client) {
        this.clients.add(client);
    }

    void handleConnected() {
        this.clients.stream()
            .filter(SocketChannel::isConnected)
            .forEach(sc -> this.handle(new Step2_ClientConnectionAnswer(sc)));
    }

    void removeNotConnected() {
        clients.removeIf(not(SocketChannel::isConnected));
    }

    private void handle(Runnable clientConnection) {
        clientConnection.run();
    }
}
