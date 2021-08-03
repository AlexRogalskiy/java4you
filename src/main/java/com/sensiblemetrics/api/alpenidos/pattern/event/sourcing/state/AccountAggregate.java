package com.sensiblemetrics.api.alpenidos.pattern.event.sourcing.state;

import com.sensiblemetrics.api.alpenidos.pattern.event.sourcing.model.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This is the static accounts map holder class.
 * This class holds the state of the accounts.
 * <p>
 * Created by Serdar Hamzaogullari on 06.08.2017.
 */
public class AccountAggregate {
    private static Map<Integer, Account> accounts = new HashMap<>();

    /**
     * Put account.
     *
     * @param account the account
     */
    public static void putAccount(final Account account) {
        accounts.put(account.getAccountNo(), account);
    }

    /**
     * Gets account.
     *
     * @param accountNo the account no
     * @return the copy of the account or null if not found
     */
    public static Account getAccount(int accountNo) {
        return Optional.ofNullable(accounts.get(accountNo)).map(Account::copy).orElse(null);
    }

    /**
     * Reset state.
     */
    public static void resetState() {
        accounts = new HashMap<>();
    }
}
