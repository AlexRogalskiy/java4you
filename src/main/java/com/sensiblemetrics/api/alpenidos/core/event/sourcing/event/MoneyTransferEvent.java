package com.sensiblemetrics.api.alpenidos.core.event.sourcing.event;

import com.sensiblemetrics.api.alpenidos.core.event.sourcing.model.Account;
import com.sensiblemetrics.api.alpenidos.core.event.sourcing.state.AccountAggregate;
import lombok.Data;

import java.math.BigDecimal;

/**
 * This is the class that implements money transfer event.
 * Holds the necessary info for a money transfer event.
 * Implements the process function that finds the event related
 * domain objects and calls the related domain object's handle event functions
 * <p>
 * Created by Serdar Hamzaogullari on 06.08.2017.
 */
@Data
public class MoneyTransferEvent extends DomainEvent {
    private final BigDecimal money;
    private final int accountNoFrom;
    private final int accountNoTo;

    /**
     * Instantiates a new Money transfer event.
     *
     * @param sequenceId    the sequence id
     * @param createdTime   the created time
     * @param money         the money
     * @param accountNoFrom the account no from
     * @param accountNoTo   the account no to
     */
    public MoneyTransferEvent(long sequenceId, long createdTime, BigDecimal money, int accountNoFrom, int accountNoTo) {
        super(sequenceId, createdTime, "MoneyTransferEvent");
        this.money = money;
        this.accountNoFrom = accountNoFrom;
        this.accountNoTo = accountNoTo;
    }

    @Override
    public void process() {
        Account accountFrom = AccountAggregate.getAccount(accountNoFrom);
        if (accountFrom == null) {
            throw new RuntimeException("Account not found " + accountNoFrom);
        }
        Account accountTo = AccountAggregate.getAccount(accountNoTo);
        if (accountTo == null) {
            throw new RuntimeException("Account not found " + accountNoTo);
        }
        accountFrom.handleTransferFromEvent(this);
        accountTo.handleTransferToEvent(this);
    }
}
