package com.sensiblemetrics.api.alpenidos.core.hexagonal.module;

import com.google.inject.AbstractModule;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.banking.MongoBank;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.banking.WireTransfers;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.eventlog.LotteryEventLog;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.eventlog.MongoEventLog;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.repository.LotteryTicketRepository;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.repository.MongoTicketRepository;

/**
 * Guice module for binding production dependencies
 */
public class LotteryModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(LotteryTicketRepository.class).to(MongoTicketRepository.class);
        bind(LotteryEventLog.class).to(MongoEventLog.class);
        bind(WireTransfers.class).to(MongoBank.class);
    }
}
