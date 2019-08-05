package com.sensiblemetrics.api.alpenidos.core.poison_pill.impl;

import com.sensiblemetrics.api.alpenidos.core.poison_pill.iface.Message;
import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link Message} basic implementation
 */
@Data
public class SimpleMessage implements Message {
    private final Map<Headers, String> headers = new HashMap<>();
    private String body;

    @Override
    public void addHeader(final Headers header, final String value) {
        this.headers.put(header, value);
    }

    @Override
    public String getHeader(final Headers header) {
        return this.headers.get(header);
    }

    @Override
    public Map<Headers, String> getHeaders() {
        return Collections.unmodifiableMap(this.headers);
    }
}