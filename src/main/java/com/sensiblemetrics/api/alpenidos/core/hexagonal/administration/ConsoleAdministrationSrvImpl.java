package com.sensiblemetrics.api.alpenidos.core.hexagonal.administration;

import com.sensiblemetrics.api.alpenidos.core.hexagonal.domain.LotteryAdministration;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.domain.LotteryNumbers;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;

/**
 * Console implementation for lottery administration
 */
@RequiredArgsConstructor
public class ConsoleAdministrationSrvImpl implements ConsoleAdministrationSrv {
    private final LotteryAdministration administration;
    private final Logger logger;

    @Override
    public void getAllSubmittedTickets() {
        this.administration.getAllSubmittedTickets().forEach((k, v) -> logger.info("Key: {}, Value: {}", k, v));
    }

    @Override
    public void performLottery() {
        final LotteryNumbers numbers = this.administration.performLottery();
        logger.info("The winning numbers: {}", numbers.getNumbersAsString());
        logger.info("Time to reset the database for next round, eh?");
    }

    @Override
    public void resetLottery() {
        this.administration.resetLottery();
        logger.info("The lottery ticket database was cleared.");
    }
}
