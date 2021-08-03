package com.sensiblemetrics.api.alpenidos.pattern.commander.messaging_service;

import com.sensiblemetrics.api.alpenidos.pattern.commander.impl.Database;
import com.sensiblemetrics.api.alpenidos.pattern.commander.exception.DatabaseUnavailableException;
import lombok.RequiredArgsConstructor;

import java.util.Hashtable;

/**
 * The MessagingDatabase is where the MessageRequest is added.
 */
@RequiredArgsConstructor
public class MessagingDatabase extends Database<MessagingService.MessageRequest> {
    private final Hashtable<String, MessagingService.MessageRequest> data;

    public MessagingDatabase() {
        this(new Hashtable<>());
    }

    @Override
    public MessagingService.MessageRequest add(final MessagingService.MessageRequest r) throws DatabaseUnavailableException {
        return this.data.put(r.getReqId(), r);
    }

    @Override
    public MessagingService.MessageRequest get(final String rId) throws DatabaseUnavailableException {
        return this.data.get(rId);
    }
}
