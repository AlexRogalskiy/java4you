package com.sensiblemetrics.api.alpenidos.core.proxy5.model;

import com.sensiblemetrics.api.alpenidos.core.proxy5.impl.SecuredPayment;
import com.sensiblemetrics.api.alpenidos.core.proxy5.iface.Payment;
import com.sensiblemetrics.api.alpenidos.core.proxy5.impl.Check;
import com.sensiblemetrics.api.alpenidos.core.proxy5.impl.Money;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankAccount {
    private String name;
    private int balance;

    public synchronized Payment withdraw(final int amount) {
        this.balance -= amount;
        return new Money(amount);
    }

    public synchronized Payment withdrawSecured(final Authority authority, final int amount) {
        return new SecuredPayment(authority, this.withdraw(amount));
    }

    public synchronized void deposit(final Payment money) {
        this.balance += money.withdraw();
    }

    public Payment cutCheck(final int amount) {
        return new Check(this, amount);
    }

    @Override
    public String toString() {
        return "\t" + this.name + " Balance: " + this.balance;
    }
}
