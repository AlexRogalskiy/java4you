package com.sensiblemetrics.api.alpenidos.pattern.cor.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeneralManager extends Leader {

    public GeneralManager(final String name) {
        super(name);
    }

    public void handleRequest(final LeaveRequest request) {
        if (request.getLeaveDays() < 30) {
            log.info("Name: " + this.name + ", leaveName: " + request.getLeaveName() + ", leaveDays: " + request.getLeaveDays());
        } else {
            log.info("LeaveName: " + request.getLeaveName() + ", leaveDays: " + request.getLeaveDays());
        }
    }
}
