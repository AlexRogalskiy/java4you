package com.sensiblemetrics.api.alpenidos.pattern.hexagonal.domain;

import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.banking.WireTransfers;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.eventlog.LotteryEventLog;
import com.sensiblemetrics.api.alpenidos.pattern.hexagonal.repository.LotteryTicketRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * Implementation for lottery service
 */
@RequiredArgsConstructor
public class LotteryService {
    private final LotteryTicketRepository repository;
    private final LotteryEventLog notifications;
    private final WireTransfers wireTransfers;

    /**
     * Submit lottery ticket to participate in the lottery
     */
    public Optional<LotteryTicketId> submitTicket(final LotteryTicket ticket) {
        final boolean result = this.wireTransfers.transferFunds(LotteryConstants.TICKET_PRIZE, ticket.getPlayerDetails().getBankAccount(), LotteryConstants.SERVICE_BANK_ACCOUNT);
        if (!result) {
            this.notifications.ticketSubmitError(ticket.getPlayerDetails());
            return Optional.empty();
        }
        final Optional<LotteryTicketId> optional = this.repository.save(ticket);
        if (optional.isPresent()) {
            this.notifications.ticketSubmitted(ticket.getPlayerDetails());
        }
        return optional;
    }

    /**
     * Check if lottery ticket has won
     */
    public LotteryTicketCheckResult checkTicketForPrize(final LotteryTicketId id, final LotteryNumbers winningNumbers) {
        return LotteryUtils.checkTicketForPrize(this.repository, id, winningNumbers);
    }
}
