package com.sensiblemetrics.api.alpenidos.core.event.sourcing.event;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * This is the base class for domain events. All events must extend this class.
 * <p>
 * Created by Serdar Hamzaogullari on 06.08.2017.
 */
@Data
@RequiredArgsConstructor
public abstract class DomainEvent implements Serializable {
    private final long sequenceId;
    private final long createdTime;
    private final String eventClassName;
    private boolean realTime = true;

    /**
     * Process.
     */
    public abstract void process();
}
