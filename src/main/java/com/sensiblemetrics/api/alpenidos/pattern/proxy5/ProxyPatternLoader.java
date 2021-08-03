package com.sensiblemetrics.api.alpenidos.pattern.proxy5;

import com.sensiblemetrics.api.alpenidos.pattern.proxy5.iface.Payment;
import com.sensiblemetrics.api.alpenidos.pattern.proxy5.model.Authority;
import com.sensiblemetrics.api.alpenidos.pattern.proxy5.model.BankAccount;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxyPatternLoader {

    public static void main(final String[] args) {
        final ProxyPatternLoader demonstration = new ProxyPatternLoader();
        demonstration.direct();
        demonstration.check();
        demonstration.authorization();
    }

    public void direct() {
        log.info("Direct Money Transfer");

        final BankAccount bankAccount1 = new BankAccount("One", 10000);
        final BankAccount bankAccount2 = new BankAccount("Two", 100);
        this.logAccounts("Before withdraw", bankAccount1, bankAccount2);

        final Payment oneHundred = bankAccount1.withdraw(100);
        logAccounts("After withdraw", bankAccount1, bankAccount2);

        bankAccount2.deposit(oneHundred);
        logAccounts("After Deposit", bankAccount1, bankAccount2);
    }

    public void check() {
        log.info("Check Money Transfer");

        final BankAccount bankAccount1 = new BankAccount("One", 10000);
        final BankAccount bankAccount2 = new BankAccount("Two", 100);
        logAccounts("Before withdraw", bankAccount1, bankAccount2);

        final Payment check = bankAccount1.cutCheck(100);
        logAccounts("After withdraw", bankAccount1, bankAccount2);

        bankAccount2.deposit(check);
        logAccounts("After Deposit", bankAccount1, bankAccount2);
    }

    private void authorization() {
        log.info("Check Money Transfer");

        final BankAccount bankAccount1 = new BankAccount("One", 10000);
        final BankAccount bankAccount2 = new BankAccount("Two", 100);
        final Authority authority = new Authority();
        logAccounts("Before withdraw", bankAccount1, bankAccount2);

        final Payment check = bankAccount1.withdrawSecured(authority, 100);

        logAccounts("After withdraw", bankAccount1, bankAccount2);
        bankAccount2.deposit(check);

        logAccounts("After Deposit", bankAccount1, bankAccount2);
        authority.authorize("please");

        bankAccount2.deposit(check);
        logAccounts("After Magic Word", bankAccount1, bankAccount2);
    }

    private void logAccounts(final String message, final BankAccount bankAccount1, final BankAccount bankAccount2) {
        log.info(message);
        log.info("BankAccount #1: " + bankAccount1);
        log.info("BankAccount #2: " + bankAccount2);
    }
}
