package com.sensiblemetrics.api.alpenidos.pattern.chain2.model;

import com.sensiblemetrics.api.alpenidos.pattern.chain2.enums.RequestType;
import lombok.Data;

import java.util.Objects;

/**
 * Request
 */
@Data
public class Request {

    /**
     * The type of this request, used by each item in the chain to see if they should or can handle
     * this particular request
     */
    private final RequestType requestType;

    /**
     * A description of the request
     */
    private final String requestDescription;

    /**
     * Indicates if the request is handled or not. A request can only switch state from unhandled to
     * handled, there's no way to 'unhandle' a request
     */
    private boolean handled;

    /**
     * Create a new request of the given type and accompanied description.
     *
     * @param requestType        The type of request
     * @param requestDescription The description of the request
     */
    public Request(final RequestType requestType, final String requestDescription) {
        this.requestType = Objects.requireNonNull(requestType);
        this.requestDescription = Objects.requireNonNull(requestDescription);
    }

    public void markHandled() {
        this.handled = true;
    }

    @Override
    public String toString() {
        return this.getRequestDescription();
    }
}
