package com.sensiblemetrics.api.alpenidos.pattern.event.sourcing.event;

import com.sensiblemetrics.api.alpenidos.pattern.event.sourcing.model.Account;
import com.sensiblemetrics.api.alpenidos.pattern.event.sourcing.state.AccountAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * This is the class that implements money deposit event.
 * Holds the necessary info for a money deposit event.
 * Implements the process function that finds the event related
 * domain objects and calls the related domain object's handle event functions
 * <p>
 * Created by Serdar Hamzaogullari on 06.08.2017.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MoneyDepositEvent extends DomainEvent {
    private final BigDecimal money;
    private final int accountNo;

    /**
     * Instantiates a new Money deposit event.
     *
     * @param sequenceId  the sequence id
     * @param createdTime the created time
     * @param accountNo   the account no
     * @param money       the money
     */
    public MoneyDepositEvent(long sequenceId, long createdTime, int accountNo, final BigDecimal money) {
        super(sequenceId, createdTime, "MoneyDepositEvent");
        this.money = money;
        this.accountNo = accountNo;
    }

    @Override
    public void process() {
        Account account = AccountAggregate.getAccount(accountNo);
        Optional.ofNullable(AccountAggregate.getAccount(accountNo)).ifPresentOrElse(a -> a.handleEvent(this), () -> {
            throw new RuntimeException("Account not found");
        });
    }
}
