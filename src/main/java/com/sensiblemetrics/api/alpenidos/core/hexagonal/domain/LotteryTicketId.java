package com.sensiblemetrics.api.alpenidos.core.hexagonal.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Lottery ticked id
 */
@Data
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class LotteryTicketId {
    private static AtomicInteger numAllocated = new AtomicInteger(0);
    private final int id;

    public LotteryTicketId() {
        this.id = numAllocated.incrementAndGet();
    }
}
