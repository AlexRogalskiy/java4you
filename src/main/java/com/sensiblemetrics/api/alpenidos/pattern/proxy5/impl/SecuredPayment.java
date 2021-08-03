package com.sensiblemetrics.api.alpenidos.pattern.proxy5.impl;

import com.sensiblemetrics.api.alpenidos.pattern.proxy5.iface.Payment;
import com.sensiblemetrics.api.alpenidos.pattern.proxy5.model.Authority;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecuredPayment implements Payment {
    private Authority authority;
    private Payment withdraw;

    @Override
    public int withdraw() {
        if (this.authority.canProcessPayment()) {
            return this.withdraw.withdraw();
        }
        return 0;
    }

    @Override
    public int getAmount() {
        return this.withdraw.getAmount();
    }
}
