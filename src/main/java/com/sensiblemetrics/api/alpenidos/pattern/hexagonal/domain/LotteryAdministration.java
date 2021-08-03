package com.sensiblemetrics.api.alpenidos.pattern.hexagonal.domain;

import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.banking.WireTransfers;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.eventlog.LotteryEventLog;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.repository.LotteryTicketRepository;
import lombok.RequiredArgsConstructor;

import java.util.Map;

/**
 * Lottery administration implementation
 */
@RequiredArgsConstructor
public class LotteryAdministration {
    private final LotteryTicketRepository repository;
    private final LotteryEventLog notifications;
    private final WireTransfers wireTransfers;

    /**
     * Get all the lottery tickets submitted for lottery
     */
    public Map<LotteryTicketId, LotteryTicket> getAllSubmittedTickets() {
        return this.repository.findAll();
    }

    /**
     * Draw lottery numbers
     */
    public LotteryNumbers performLottery() {
        final LotteryNumbers numbers = LotteryNumbers.createRandom();
        final Map<LotteryTicketId, LotteryTicket> tickets = this.getAllSubmittedTickets();
        for (final LotteryTicketId id : tickets.keySet()) {
            final LotteryTicketCheckResult result = LotteryUtils.checkTicketForPrize(repository, id, numbers);
            if (result.getResult().equals(LotteryTicketCheckResult.CheckResult.WIN_PRIZE)) {
                boolean transferred = this.wireTransfers.transferFunds(LotteryConstants.PRIZE_AMOUNT, LotteryConstants.SERVICE_BANK_ACCOUNT, tickets.get(id).getPlayerDetails().getBankAccount());
                if (transferred) {
                    this.notifications.ticketWon(tickets.get(id).getPlayerDetails(), LotteryConstants.PRIZE_AMOUNT);
                } else {
                    this.notifications.prizeError(tickets.get(id).getPlayerDetails(), LotteryConstants.PRIZE_AMOUNT);
                }
            } else if (result.getResult().equals(LotteryTicketCheckResult.CheckResult.NO_PRIZE)) {
                this.notifications.ticketDidNotWin(tickets.get(id).getPlayerDetails());
            }
        }
        return numbers;
    }

    /**
     * Begin new lottery round
     */
    public void resetLottery() {
        this.repository.deleteAll();
    }
}
