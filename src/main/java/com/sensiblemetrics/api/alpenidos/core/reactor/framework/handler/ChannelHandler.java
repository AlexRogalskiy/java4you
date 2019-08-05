package com.sensiblemetrics.api.alpenidos.core.reactor.framework.handler;

import com.sensiblemetrics.api.alpenidos.core.reactor.framework.channel.AbstractNioChannel;
import com.sensiblemetrics.api.alpenidos.core.reactor.framework.dispatcher.Dispatcher;

import java.nio.channels.SelectionKey;

/**
 * Represents the <i>EventHandler</i> of Reactor pattern. It handles the incoming events dispatched
 * to it by the {@link Dispatcher}. This is where the application logic resides.
 *
 * <p>
 * A {@link ChannelHandler} can be associated with one or many {@link AbstractNioChannel}s, and
 * whenever an event occurs on any of the associated channels, the handler is notified of the event.
 */
public interface ChannelHandler {

    /**
     * Called when the {@code channel} receives some data from remote peer.
     *
     * @param channel    the channel from which the data was received.
     * @param readObject the data read.
     * @param key        the key on which read event occurred.
     */
    void handleChannelRead(final AbstractNioChannel channel, final Object readObject, final SelectionKey key);
}
