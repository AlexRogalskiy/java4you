package com.sensiblemetrics.api.alpenidos.core.proxy5.impl;

import com.sensiblemetrics.api.alpenidos.core.proxy5.iface.Payment;
import com.sensiblemetrics.api.alpenidos.core.utils.ValidationUtils;

public class Money implements Payment {
    private int amount;

    public Money(int amount) {
        ValidationUtils.isTrue(amount >= 0, "Amount should not be negative");
        this.amount = amount;
    }

    @Override
    public int withdraw() {
        int withdrawAmount = this.amount;
        this.amount = 0;
        return withdrawAmount;
    }

    @Override
    public int getAmount() {
        return this.amount;
    }
}
