package com.sensiblemetrics.api.alpenidos.core.hexagonal.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents lottery ticket check result.
 */
@Data
@EqualsAndHashCode
@ToString
public class LotteryTicketCheckResult {

    /**
     * Enumeration of Type of Outcomes of a Lottery
     */
    public enum CheckResult {WIN_PRIZE, NO_PRIZE, TICKET_NOT_SUBMITTED}

    private final CheckResult checkResult;
    private final int prizeAmount;

    /**
     * Constructor.
     */
    public LotteryTicketCheckResult(final CheckResult result) {
        this.checkResult = result;
        this.prizeAmount = 0;
    }

    /**
     * Constructor.
     */
    public LotteryTicketCheckResult(final CheckResult result, final int amount) {
        this.checkResult = result;
        this.prizeAmount = amount;
    }

    /**
     * @return check result
     */
    public CheckResult getResult() {
        return this.checkResult;
    }

    /**
     * @return prize amount
     */
    public int getPrizeAmount() {
        return this.prizeAmount;
    }
}
