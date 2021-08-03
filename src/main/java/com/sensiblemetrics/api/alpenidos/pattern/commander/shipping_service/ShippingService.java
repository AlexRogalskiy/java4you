package com.sensiblemetrics.api.alpenidos.pattern.commander.shipping_service;

import com.sensiblemetrics.api.alpenidos.pattern.commander.impl.Commander;
import com.sensiblemetrics.api.alpenidos.pattern.commander.impl.Service;
import com.sensiblemetrics.api.alpenidos.pattern.commander.exception.DatabaseUnavailableException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ShippingService class receives request from {@link Commander} class and adds it
 * to the {@link ShippingDatabase}.
 */
public class ShippingService extends Service {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class ShippingRequest {
        private String transactionId;
        private String item;
        private String address;
    }

    public ShippingService(final ShippingDatabase db, final Exception... exc) {
        super(db, exc);
    }

    /**
     * Public method which will receive request from {@link Commander}.
     */
    public String receiveRequest(final Object... parameters) throws DatabaseUnavailableException {
        final String tId = this.generateId();
        final ShippingRequest req = new ShippingRequest(tId, (String) parameters[0] /*item*/, (String) parameters[1]/*address*/);
        return this.updateDb(req);
    }

    protected String updateDb(final Object... parameters) throws DatabaseUnavailableException {
        final ShippingRequest req = (ShippingRequest) parameters[0];
        if (this.database.get(req.transactionId) == null) {
            this.database.add(req);
            return req.transactionId;
        }
        return null;
    }
}
