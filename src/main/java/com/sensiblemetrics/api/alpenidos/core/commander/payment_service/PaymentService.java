package com.sensiblemetrics.api.alpenidos.core.commander.payment_service;

import com.sensiblemetrics.api.alpenidos.core.commander.impl.Commander;
import com.sensiblemetrics.api.alpenidos.core.commander.impl.Service;
import com.sensiblemetrics.api.alpenidos.core.commander.exception.DatabaseUnavailableException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The PaymentService class receives request from the {@link Commander} and adds
 * to the {@link PaymentDatabase}.
 */
public class PaymentService extends Service {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class PaymentRequest {
        private String transactionId;
        private float payment;
        private boolean paid;
    }

    public PaymentService(final PaymentDatabase db, final Exception... exc) {
        super(db, exc);
    }

    /**
     * Public method which will receive request from {@link Commander}.
     */
    public String receiveRequest(final Object... parameters) throws DatabaseUnavailableException {
        //it could also be sending a userid, payment details here or something, not added here
        final String tId = this.generateId();
        final PaymentRequest req = new PaymentRequest(tId, (float) parameters[0], false);
        return this.updateDb(req);
    }

    protected String updateDb(final Object... parameters) throws DatabaseUnavailableException {
        final PaymentRequest req = (PaymentRequest) parameters[0];
        if (this.database.get(req.transactionId) == null || !req.paid) {
            this.database.add(req);
            req.paid = true;
            return req.transactionId;
        }
        return null;
    }
}
