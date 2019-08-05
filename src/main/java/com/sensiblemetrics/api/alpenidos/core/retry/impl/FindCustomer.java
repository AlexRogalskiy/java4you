package com.sensiblemetrics.api.alpenidos.core.retry.impl;

import com.sensiblemetrics.api.alpenidos.core.retry.exception.BusinessException;
import com.sensiblemetrics.api.alpenidos.core.retry.iface.BusinessOperation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Finds a customer, returning its ID from our records.
 * <p>
 * This is an imaginary operation that, for some imagined input, returns the ID for a customer.
 * However, this is a "flaky" operation that is supposed to fail intermittently, but for the
 * purposes of this example it fails in a programmed way depending on the constructor parameters.
 *
 * @author George Aristy (george.aristy@gmail.com)
 */
public final class FindCustomer implements BusinessOperation<String> {
    private final String customerId;
    private final Deque<BusinessException> errors;

    /**
     * Ctor.
     *
     * @param customerId the final result of the remote operation
     * @param errors     the errors to throw before returning {@code customerId}
     */
    public FindCustomer(final String customerId, final BusinessException... errors) {
        this.customerId = customerId;
        this.errors = new ArrayDeque<>(Arrays.asList(errors));
    }

    @Override
    public String perform() throws BusinessException {
        if (!this.errors.isEmpty()) {
            throw this.errors.pop();
        }
        return this.customerId;
    }
}
