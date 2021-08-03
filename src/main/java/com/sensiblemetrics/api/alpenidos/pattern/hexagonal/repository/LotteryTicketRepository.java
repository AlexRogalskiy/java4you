package com.sensiblemetrics.api.alpenidos.pattern.hexagonal.repository;

import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.domain.LotteryTicket;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.domain.LotteryTicketId;

import java.util.Map;
import java.util.Optional;

/**
 * Interface for accessing lottery tickets in database.
 */
public interface LotteryTicketRepository {

    /**
     * Find lottery ticket by id
     */
    Optional<LotteryTicket> findById(final LotteryTicketId id);

    /**
     * Save lottery ticket
     */
    Optional<LotteryTicketId> save(final LotteryTicket ticket);

    /**
     * Get all lottery tickets
     */
    Map<LotteryTicketId, LotteryTicket> findAll();

    /**
     * Delete all lottery tickets
     */
    void deleteAll();
}
