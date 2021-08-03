package com.sensiblemetrics.api.alpenidos.pattern.cor.model;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class Manager extends Leader {

    public Manager(final String name) {
        super(name);
    }

    public void handleRequest(final LeaveRequest request) {
        if (request.getLeaveDays() < 10) {
            log.info("Name: " + this.name + ", leaveName: " + request.getLeaveName() + ", leaveDays: " + request.getLeaveDays());
        } else {
            Optional.ofNullable(this.successor).ifPresent(h -> h.handleRequest(request));
        }
    }
}
