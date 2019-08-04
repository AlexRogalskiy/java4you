package com.sensiblemetrics.api.alpenidos.core.hexagonal.domain;

import com.sensiblemetrics.api.alpenidos.core.hexagonal.repository.LotteryTicketRepository;
import lombok.experimental.UtilityClass;

import java.util.Optional;

/**
 * Lottery utilities
 */
@UtilityClass
public class LotteryUtils {

    /**
     * Checks if lottery ticket has won
     */
    public static LotteryTicketCheckResult checkTicketForPrize(final LotteryTicketRepository repository, final LotteryTicketId id, final LotteryNumbers winningNumbers) {
        final Optional<LotteryTicket> optional = repository.findById(id);
        if (optional.isPresent()) {
            if (optional.get().getNumbers().equals(winningNumbers)) {
                return new LotteryTicketCheckResult(LotteryTicketCheckResult.CheckResult.WIN_PRIZE, 1000);
            }
            return new LotteryTicketCheckResult(LotteryTicketCheckResult.CheckResult.NO_PRIZE);
        }
        return new LotteryTicketCheckResult(LotteryTicketCheckResult.CheckResult.TICKET_NOT_SUBMITTED);
    }
}
