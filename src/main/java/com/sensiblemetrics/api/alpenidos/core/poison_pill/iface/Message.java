package com.sensiblemetrics.api.alpenidos.core.poison_pill.iface;

import com.sensiblemetrics.api.alpenidos.core.poison_pill.impl.Consumer;
import com.sensiblemetrics.api.alpenidos.core.poison_pill.impl.Producer;

import java.util.Map;

/**
 * Interface that implements the Message pattern and represents an inbound or outbound message as
 * part of an {@link Producer}-{@link Consumer} exchange.
 */
public interface Message {

    Message POISON_PILL = new Message() {

        @Override
        public void addHeader(final Headers header, final String value) {
            throw this.poison();
        }

        @Override
        public String getHeader(final Headers header) {
            throw this.poison();
        }

        @Override
        public Map<Headers, String> getHeaders() {
            throw this.poison();
        }

        @Override
        public void setBody(final String body) {
            throw this.poison();
        }

        @Override
        public String getBody() {
            throw this.poison();
        }

        private RuntimeException poison() {
            return new UnsupportedOperationException("Poison");
        }
    };

    /**
     * Enumeration of Type of Headers
     */
    enum Headers {
        DATE,
        SENDER
    }

    void addHeader(final Headers header, final String value);

    String getHeader(final Headers header);

    Map<Headers, String> getHeaders();

    void setBody(final String body);

    String getBody();
}
