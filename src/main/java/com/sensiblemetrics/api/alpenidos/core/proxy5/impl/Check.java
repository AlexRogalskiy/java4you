package com.sensiblemetrics.api.alpenidos.core.proxy5.impl;

import com.sensiblemetrics.api.alpenidos.core.proxy5.iface.Payment;
import com.sensiblemetrics.api.alpenidos.core.proxy5.model.BankAccount;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Check implements Payment {
    private BankAccount bankAccount;
    private int amount;

    @Override
    public int withdraw() {
        final Payment withdraw = this.bankAccount.withdraw(this.amount);
        return withdraw.withdraw();
    }

    @Override
    public int getAmount() {
        return this.amount;
    }
}
