package com.sensiblemetrics.api.alpenidos.pattern.commander.shipping_service;

import com.sensiblemetrics.api.alpenidos.pattern.commander.impl.Database;
import com.sensiblemetrics.api.alpenidos.pattern.commander.exception.DatabaseUnavailableException;
import lombok.RequiredArgsConstructor;

import java.util.Hashtable;

/**
 * ShippingDatabase is where the ShippingRequest objects are added.
 */
@RequiredArgsConstructor
public class ShippingDatabase extends Database<ShippingService.ShippingRequest> {
    private final Hashtable<String, ShippingService.ShippingRequest> data;

    public ShippingDatabase() {
        this(new Hashtable<>());
    }

    @Override
    public ShippingService.ShippingRequest add(final ShippingService.ShippingRequest r) throws DatabaseUnavailableException {
        return this.data.put(r.getTransactionId(), r);
    }

    public ShippingService.ShippingRequest get(final String transactionId) throws DatabaseUnavailableException {
        return this.data.get(transactionId);
    }
}
