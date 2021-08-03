package com.sensiblemetrics.api.alpenidos.pattern.reactor.framework.channel;

import com.sensiblemetrics.api.alpenidos.pattern.reactor.framework.NioReactor;
import com.sensiblemetrics.api.alpenidos.pattern.reactor.framework.handler.ChannelHandler;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * This represents the <i>Handle</i> of Reactor pattern. These are resources managed by OS which can
 * be submitted to {@link NioReactor}.
 *
 * <p>
 * This class serves has the responsibility of reading the data when a read event occurs and writing
 * the data back when the channel is writable. It leaves the reading and writing of data on the
 * concrete implementation. It provides a block writing mechanism wherein when any
 * {@link ChannelHandler} wants to write data back, it queues the data in pending write queue and
 * clears it in block manner. This provides better throughput.
 */
@RequiredArgsConstructor
public abstract class AbstractNioChannel {
    private final Map<SelectableChannel, Queue<Object>> channelToPendingWrites = new ConcurrentHashMap<>();

    private final SelectableChannel channel;
    private final ChannelHandler handler;
    private NioReactor reactor;

    /**
     * Injects the reactor in this channel.
     */
    public void setReactor(final NioReactor reactor) {
        this.reactor = reactor;
    }

    /**
     * @return the wrapped NIO channel.
     */
    public SelectableChannel getJavaChannel() {
        return this.channel;
    }

    /**
     * @return the handler associated with this channel.
     */
    public ChannelHandler getHandler() {
        return this.handler;
    }

    /**
     * The operation in which the channel is interested, this operation is provided to
     * {@link Selector}.
     *
     * @return interested operation.
     * @see SelectionKey
     */
    public abstract int getInterestedOps();

    /**
     * Binds the channel on provided port.
     *
     * @throws IOException if any I/O error occurs.
     */
    public abstract void bind() throws IOException;

    /**
     * Reads the data using the key and returns the read data. The underlying channel should be
     * fetched using {@link SelectionKey#channel()}.
     *
     * @param key the key on which read event occurred.
     * @return data read.
     * @throws IOException if any I/O error occurs.
     */
    public abstract Object read(final SelectionKey key) throws IOException;

    /*
     * Called from the context of reactor thread when the key becomes writable. The channel writes the
     * whole pending block of data at once.
     */
    public void flush(final SelectionKey key) throws IOException {
        final Queue<Object> pendingWrites = this.channelToPendingWrites.get(key.channel());
        while (true) {
            final Object pendingWrite = pendingWrites.poll();
            if (pendingWrite == null) {
                this.reactor.changeOps(key, SelectionKey.OP_READ);
                break;
            }
            // ask the concrete channel to make sense of data and write it to java channel
            this.doWrite(pendingWrite, key);
        }
    }

    /**
     * Writes the data to the channel.
     *
     * @param pendingWrite the data to be written on channel.
     * @param key          the key which is writable.
     * @throws IOException if any I/O error occurs.
     */
    protected abstract void doWrite(final Object pendingWrite, final SelectionKey key) throws IOException;

    /**
     * Queues the data for writing. The data is not guaranteed to be written on underlying channel
     * when this method returns. It will be written when the channel is flushed.
     *
     * <p>
     * This method is used by the {@link ChannelHandler} to send reply back to the client. <br>
     * Example:
     *
     * <pre>
     * <code>
     * {@literal @}Override
     * public void handleChannelRead(com.sensiblemetrics.api.alpenidos.core.reactor.framework.impl.AbstractNioChannel channel, Object readObject, SelectionKey key) {
     *   byte[] data = ((ByteBuffer)readObject).array();
     *   ByteBuffer buffer = ByteBuffer.wrap("Server reply".getBytes());
     *   channel.write(buffer, key);
     * }
     * </code>
     * </pre>
     *
     * @param data the data to be written on underlying channel.
     * @param key  the key which is writable.
     */
    public void write(final Object data, final SelectionKey key) {
        Queue<Object> pendingWrites = this.channelToPendingWrites.get(key.channel());
        if (pendingWrites == null) {
            synchronized (this.channelToPendingWrites) {
                pendingWrites = this.channelToPendingWrites.get(key.channel());
                if (pendingWrites == null) {
                    pendingWrites = new ConcurrentLinkedQueue<>();
                    this.channelToPendingWrites.put(key.channel(), pendingWrites);
                }
            }
        }
        pendingWrites.add(data);
        this.reactor.changeOps(key, SelectionKey.OP_WRITE);
    }
}
