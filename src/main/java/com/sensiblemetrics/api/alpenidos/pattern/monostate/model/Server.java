package com.sensiblemetrics.api.alpenidos.pattern.monostate.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * The Server class. Each Server sits behind a LoadBalancer which delegates the call to the servers
 * in a simplistic Round Robin fashion.
 */
@Slf4j
@Getter
@RequiredArgsConstructor
public class Server {
    public final String host;
    public final int port;
    public final int id;

    public void serve(Request request) {
        log.info("Server ID {} associated to host : {} and port {}. Processed request with value {}", this.id, this.host, this.port, request.value);
    }
}
