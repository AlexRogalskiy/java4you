package com.sensiblemetrics.api.alpenidos.core.event.sourcing.model;

import com.sensiblemetrics.api.alpenidos.core.event.sourcing.event.AccountCreateEvent;
import com.sensiblemetrics.api.alpenidos.core.event.sourcing.event.MoneyDepositEvent;
import com.sensiblemetrics.api.alpenidos.core.event.sourcing.event.MoneyTransferEvent;
import com.sensiblemetrics.api.alpenidos.core.event.sourcing.state.AccountAggregate;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * This is the Account class that holds the account info, the account number,
 * account owner name and money of the account. Account class also have the business logic of events
 * that effects this account.
 * <p>
 * Created by Serdar Hamzaogullari on 06.08.2017.
 */
@Slf4j
@Data
public class Account {
    /**
     * Default message
     */
    private static final String MSG = "Some external api for only realtime execution could be called here.";

    private final int accountNo;
    private final String owner;
    private BigDecimal money;

    /**
     * Instantiates a new Account.
     *
     * @param accountNo the account no
     * @param owner     the owner
     */
    public Account(int accountNo, String owner) {
        this.accountNo = accountNo;
        this.owner = owner;
        money = BigDecimal.ZERO;
    }

    /**
     * Copy account.
     *
     * @return the account
     */
    public Account copy() {
        Account account = new Account(accountNo, owner);
        account.setMoney(money);
        return account;
    }

    private void depositMoney(final BigDecimal money) {
        this.money = this.money.add(money);
    }

    private void withdrawMoney(final BigDecimal money) {
        this.money = this.money.subtract(money);
    }

    private void handleDeposit(final BigDecimal money, boolean realTime) {
        this.depositMoney(money);
        AccountAggregate.putAccount(this);
        if (realTime) {
            log.info(MSG);
        }
    }

    private void handleWithdrawal(final BigDecimal money, final boolean realTime) {
        if (this.money.compareTo(money) == -1) {
            throw new RuntimeException("Insufficient Account Balance");
        }
        this.withdrawMoney(money);
        AccountAggregate.putAccount(this);
        if (realTime) {
            log.info(MSG);
        }
    }

    /**
     * Handles the MoneyDepositEvent.
     *
     * @param moneyDepositEvent the money deposit event
     */
    public void handleEvent(final MoneyDepositEvent moneyDepositEvent) {
        handleDeposit(moneyDepositEvent.getMoney(), moneyDepositEvent.isRealTime());
    }


    /**
     * Handles the AccountCreateEvent.
     *
     * @param accountCreateEvent the account create event
     */
    public void handleEvent(final AccountCreateEvent accountCreateEvent) {
        AccountAggregate.putAccount(this);
        if (accountCreateEvent.isRealTime()) {
            log.info(MSG);
        }
    }

    /**
     * Handles transfer from account event.
     *
     * @param moneyTransferEvent the money transfer event
     */
    public void handleTransferFromEvent(final MoneyTransferEvent moneyTransferEvent) {
        handleWithdrawal(moneyTransferEvent.getMoney(), moneyTransferEvent.isRealTime());
    }

    /**
     * Handles transfer to account event.
     *
     * @param moneyTransferEvent the money transfer event
     */
    public void handleTransferToEvent(final MoneyTransferEvent moneyTransferEvent) {
        handleDeposit(moneyTransferEvent.getMoney(), moneyTransferEvent.isRealTime());
    }
}
