package com.sensiblemetrics.api.alpenidos.pattern.event.sourcing.processor;

import com.sensiblemetrics.api.alpenidos.pattern.event.sourcing.event.DomainEvent;

/**
 * This is the implementation of event processor.
 * All events are processed by this class.
 * This processor uses processorJournal to persist and recover events.
 * <p>
 * Created by Serdar Hamzaogullari on 06.08.2017.
 */
public class DomainEventProcessor {
    private final JsonFileJournal processorJournal = new JsonFileJournal();

    /**
     * Process.
     *
     * @param domainEvent the domain event
     */
    public void process(final DomainEvent domainEvent) {
        domainEvent.process();
        this.processorJournal.write(domainEvent);
    }

    /**
     * Reset.
     */
    public void reset() {
        this.processorJournal.reset();
    }

    /**
     * Recover.
     */
    public void recover() {
        DomainEvent domainEvent;
        while (true) {
            domainEvent = this.processorJournal.readNext();
            if (domainEvent == null) {
                break;
            } else {
                domainEvent.process();
            }
        }
    }
}
