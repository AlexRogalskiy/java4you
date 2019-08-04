package com.sensiblemetrics.api.alpenidos.core.hexagonal.repository;

import com.sensiblemetrics.api.alpenidos.core.hexagonal.domain.LotteryTicket;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.domain.LotteryTicketId;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Mock database for lottery tickets.
 */
public class InMemoryTicketRepository implements LotteryTicketRepository {

    private static Map<LotteryTicketId, LotteryTicket> tickets = new HashMap<>();

    @Override
    public Optional<LotteryTicket> findById(final LotteryTicketId id) {
        return Optional.ofNullable(tickets.get(id));
    }

    @Override
    public Optional<LotteryTicketId> save(final LotteryTicket ticket) {
        final LotteryTicketId id = new LotteryTicketId();
        tickets.put(id, ticket);
        return Optional.of(id);
    }

    @Override
    public Map<LotteryTicketId, LotteryTicket> findAll() {
        return tickets;
    }

    @Override
    public void deleteAll() {
        tickets.clear();
    }
}
