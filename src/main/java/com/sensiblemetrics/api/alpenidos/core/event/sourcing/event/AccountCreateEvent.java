package com.sensiblemetrics.api.alpenidos.core.event.sourcing.event;

import com.sensiblemetrics.api.alpenidos.core.event.sourcing.model.Account;
import com.sensiblemetrics.api.alpenidos.core.event.sourcing.state.AccountAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * This is the class that implements account create event.
 * Holds the necessary info for an account create event.
 * Implements the process function that finds the event related
 * domain objects and calls the related domain object's handle event functions
 * <p>
 * Created by Serdar Hamzaogullari on 06.08.2017.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AccountCreateEvent extends DomainEvent {
    private final int accountNo;
    private final String owner;

    /**
     * Instantiates a new Account create event.
     *
     * @param sequenceId  the sequence id
     * @param createdTime the created time
     * @param accountNo   the account no
     * @param owner       the owner
     */
    public AccountCreateEvent(long sequenceId, long createdTime, int accountNo, final String owner) {
        super(sequenceId, createdTime, "AccountCreateEvent");
        this.accountNo = accountNo;
        this.owner = owner;
    }

    @Override
    public void process() {
        Account account = AccountAggregate.getAccount(this.accountNo);
        if (account != null) {
            throw new RuntimeException("Account already exists");
        }
        account = new Account(this.accountNo, this.owner);
        account.handleEvent(this);
    }
}
