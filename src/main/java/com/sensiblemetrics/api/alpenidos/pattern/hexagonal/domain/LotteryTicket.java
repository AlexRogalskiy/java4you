package com.sensiblemetrics.api.alpenidos.pattern.hexagonal.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Immutable value object representing lottery ticket.
 */
@Data
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class LotteryTicket {
    private final LotteryTicketId id;
    private final PlayerDetails playerDetails;
    private final LotteryNumbers lotteryNumbers;

    /**
     * @return lottery numbers
     */
    public LotteryNumbers getNumbers() {
        return this.lotteryNumbers;
    }
}
