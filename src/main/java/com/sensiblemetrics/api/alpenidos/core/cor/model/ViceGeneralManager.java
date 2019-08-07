package com.sensiblemetrics.api.alpenidos.core.cor.model;

import com.sensiblemetrics.api.alpenidos.core.cor.model.Leader;
import com.sensiblemetrics.api.alpenidos.core.cor.model.LeaveRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class ViceGeneralManager extends Leader {
    public ViceGeneralManager(final String name) {
        super(name);
    }

    public void handleRequest(final LeaveRequest request) {
        if (request.getLeaveDays() < 20) {
            log.info("Name: " + this.name + ", leaveName: " + request.getLeaveName() + ", leaveDays: " + request.getLeaveDays());
        } else {
            Optional.ofNullable(this.successor).ifPresent(h -> h.handleRequest(request));
        }
    }
}
