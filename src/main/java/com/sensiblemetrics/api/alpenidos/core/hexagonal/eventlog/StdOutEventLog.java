package com.sensiblemetrics.api.alpenidos.core.hexagonal.eventlog;

import com.sensiblemetrics.api.alpenidos.core.hexagonal.domain.PlayerDetails;
import lombok.extern.slf4j.Slf4j;

/**
 * Standard output event log
 */
@Slf4j
public class StdOutEventLog implements LotteryEventLog {

    @Override
    public void ticketSubmitted(final PlayerDetails details) {
        log.info("Lottery ticket for {} was submitted. Bank account {} was charged for 3 credits.", details.getEmail(), details.getBankAccount());
    }

    @Override
    public void ticketDidNotWin(final PlayerDetails details) {
        log.info("Lottery ticket for {} was checked and unfortunately did not win this time.", details.getEmail());
    }

    @Override
    public void ticketWon(final PlayerDetails details, final int prizeAmount) {
        log.info("Lottery ticket for {} has won! The bank account {} was deposited with {} credits.", details.getEmail(), details.getBankAccount(), prizeAmount);
    }

    @Override
    public void prizeError(final PlayerDetails details, final int prizeAmount) {
        log.error("Lottery ticket for {} has won! Unfortunately the bank credit transfer of {} failed.", details.getEmail(), prizeAmount);
    }

    @Override
    public void ticketSubmitError(final PlayerDetails details) {
        log.error("Lottery ticket for {} could not be submitted because the credit transfer of 3 credits failed.", details.getEmail());
    }
}
