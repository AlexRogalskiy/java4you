package com.sensiblemetrics.api.alpenidos.pattern.hexagonal.module;

import com.google.inject.AbstractModule;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.banking.InMemoryBank;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.banking.WireTransfers;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.eventlog.LotteryEventLog;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.eventlog.StdOutEventLog;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.repository.InMemoryTicketRepository;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.repository.LotteryTicketRepository;

/**
 * Guice module for testing dependencies
 */
public class LotteryTestingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(LotteryTicketRepository.class).to(InMemoryTicketRepository.class);
        bind(LotteryEventLog.class).to(StdOutEventLog.class);
        bind(WireTransfers.class).to(InMemoryBank.class);
    }
}
