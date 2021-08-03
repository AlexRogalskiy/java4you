package com.sensiblemetrics.api.alpenidos.pattern.commander.payment_service;

import com.sensiblemetrics.api.alpenidos.pattern.commander.impl.Database;
import com.sensiblemetrics.api.alpenidos.pattern.commander.exception.DatabaseUnavailableException;
import lombok.RequiredArgsConstructor;

import java.util.Hashtable;

/**
 * PaymentDatabase is where the PaymentRequest is added, along with details.
 */
@RequiredArgsConstructor
public class PaymentDatabase extends Database<PaymentService.PaymentRequest> {
    private final Hashtable<String, PaymentService.PaymentRequest> data;

    public PaymentDatabase() {
        this(new Hashtable<>());
    }

    @Override
    public PaymentService.PaymentRequest add(final PaymentService.PaymentRequest r) throws DatabaseUnavailableException {
        return this.data.put(r.getTransactionId(), r);
    }

    @Override
    public PaymentService.PaymentRequest get(final String tId) throws DatabaseUnavailableException {
        return this.data.get(tId);
    }
}
