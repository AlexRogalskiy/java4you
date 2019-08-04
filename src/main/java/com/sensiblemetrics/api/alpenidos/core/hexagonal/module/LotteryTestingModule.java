package com.sensiblemetrics.api.alpenidos.core.hexagonal.module;

import com.google.inject.AbstractModule;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.banking.InMemoryBank;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.banking.WireTransfers;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.eventlog.LotteryEventLog;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.eventlog.StdOutEventLog;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.repository.InMemoryTicketRepository;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.repository.LotteryTicketRepository;

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
