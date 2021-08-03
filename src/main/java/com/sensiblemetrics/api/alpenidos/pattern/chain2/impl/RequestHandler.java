package com.sensiblemetrics.api.alpenidos.pattern.chain2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.chain2.model.Request;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * RequestHandler
 */
@Slf4j
@RequiredArgsConstructor
public abstract class RequestHandler {
    private final RequestHandler next;

    /**
     * Request handler
     */
    public void handleRequest(final Request req) {
        Optional.ofNullable(this.next).ifPresent(h -> h.handleRequest(req));
    }

    protected void printHandling(final Request req) {
        log.info("{} handling request \"{}\"", this, req);
    }

    @Override
    public abstract String toString();
}
