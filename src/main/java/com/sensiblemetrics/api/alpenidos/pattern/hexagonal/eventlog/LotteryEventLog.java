package com.sensiblemetrics.api.alpenidos.pattern.hexagonal.eventlog;

import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.domain.PlayerDetails;

/**
 * Event log for lottery events
 */
public interface LotteryEventLog {

    /**
     * lottery ticket submitted
     */
    void ticketSubmitted(final PlayerDetails details);

    /**
     * error submitting lottery ticket
     */
    void ticketSubmitError(final PlayerDetails details);

    /**
     * lottery ticket did not win
     */
    void ticketDidNotWin(final PlayerDetails details);

    /**
     * lottery ticket won
     */
    void ticketWon(final PlayerDetails details, final int prizeAmount);

    /**
     * error paying the prize
     */
    void prizeError(final PlayerDetails details, final int prizeAmount);
}
