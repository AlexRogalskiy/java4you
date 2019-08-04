package com.sensiblemetrics.api.alpenidos.core.hexagonal.banking;

import com.sensiblemetrics.api.alpenidos.core.hexagonal.domain.LotteryConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Banking implementation
 */
public class InMemoryBank implements WireTransfers {
    private static final Map<String, Integer> accounts = new HashMap<>();

    static {
        accounts.put(LotteryConstants.SERVICE_BANK_ACCOUNT, LotteryConstants.SERVICE_BANK_ACCOUNT_BALANCE);
    }

    @Override
    public void setFunds(final String bankAccount, final int amount) {
        accounts.put(bankAccount, amount);
    }

    @Override
    public int getFunds(final String bankAccount) {
        return accounts.getOrDefault(bankAccount, 0);
    }

    @Override
    public boolean transferFunds(final int amount, final String sourceBackAccount, final String destinationBankAccount) {
        if (accounts.getOrDefault(sourceBackAccount, 0) >= amount) {
            accounts.put(sourceBackAccount, accounts.get(sourceBackAccount) - amount);
            accounts.put(destinationBankAccount, accounts.get(destinationBankAccount) + amount);
            return true;
        }
        return false;
    }
}
