package com.sensiblemetrics.api.alpenidos.core.cor.model;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class Director extends Leader {

    public Director(final String name) {
        super(name);
    }

    public void handleRequest(final LeaveRequest request) {
        if (request.getLeaveDays() < 3) {
            log.info("name: " + name + ", leaveName: " + request.getLeaveName() + ", leaveDays: " + request.getLeaveDays());
        } else {
            Optional.ofNullable(this.successor).ifPresent(h -> h.handleRequest(request));
        }
    }
}
