package com.sensiblemetrics.api.alpenidos.core.hexagonal.service;

import com.sensiblemetrics.api.alpenidos.core.hexagonal.banking.WireTransfers;
import com.sensiblemetrics.api.alpenidos.core.hexagonal.domain.LotteryService;

import java.util.Scanner;


/**
 * Console interface for lottery service
 */
public interface LotteryConsoleService {

    void checkTicket(final LotteryService service, final Scanner scanner);

    /**
     * Submit lottery ticket to participate in the lottery
     */
    void submitTicket(final LotteryService service, final Scanner scanner);

    /**
     * Add funds to lottery account
     */
    void addFundsToLotteryAccount(final WireTransfers bank, final Scanner scanner);

    /**
     * Recovery funds from lottery account
     */
    void queryLotteryAccountFunds(final WireTransfers bank, final Scanner scanner);
}
