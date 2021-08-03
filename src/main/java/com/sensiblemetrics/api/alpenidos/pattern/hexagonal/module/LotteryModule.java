package com.sensiblemetrics.api.alpenidos.pattern.hexagonal.module;

import com.google.inject.AbstractModule;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.banking.MongoBank;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.banking.WireTransfers;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.eventlog.LotteryEventLog;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.eventlog.MongoEventLog;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.repository.LotteryTicketRepository;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.repository.MongoTicketRepository;

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
