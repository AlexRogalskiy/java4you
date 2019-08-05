package com.sensiblemetrics.api.alpenidos.core.reactor.framework.channel;

import com.sensiblemetrics.api.alpenidos.core.reactor.framework.handler.ChannelHandler;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;

/**
 * A wrapper over {@link DatagramChannel} which can read and write data on a DatagramChannel.
 */
@Slf4j
public class NioDatagramChannel extends AbstractNioChannel {
    private final int port;

    /**
     * Creates a {@link DatagramChannel} which will bind at provided port and use <code>handler</code>
     * to handle incoming events on this channel.
     * <p>
     * Note the constructor does not bind the socket, {@link #bind()} method should be called for
     * binding the socket.
     *
     * @param port    the port to be bound to listen for incoming datagram requests.
     * @param handler the handler to be used for handling incoming requests on this channel.
     * @throws IOException if any I/O error occurs.
     */
    public NioDatagramChannel(int port, ChannelHandler handler) throws IOException {
        super(DatagramChannel.open(), handler);
        this.port = port;
    }

    @Override
    public int getInterestedOps() {
        /*
         * there is no need to accept connections in UDP, so the channel shows interest in reading data.
         */
        return SelectionKey.OP_READ;
    }

    /**
     * Reads and returns a {@link DatagramPacket} from the underlying channel.
     *
     * @return the datagram packet read having the sender address.
     */
    @Override
    public DatagramPacket read(final SelectionKey key) throws IOException {
        final ByteBuffer buffer = ByteBuffer.allocate(1024);
        final SocketAddress sender = ((DatagramChannel) key.channel()).receive(buffer);
        /*
         * It is required to create a DatagramPacket because we need to preserve which socket address
         * acts as destination for sending reply packets.
         */
        buffer.flip();
        final DatagramPacket packet = new DatagramPacket(buffer);
        packet.setSender(sender);
        return packet;
    }

    /**
     * @return the underlying datagram channel.
     */
    @Override
    public DatagramChannel getJavaChannel() {
        return (DatagramChannel) super.getJavaChannel();
    }

    /**
     * Binds UDP socket on the provided <code>port</code>.
     *
     * @throws IOException if any I/O error occurs.
     */
    @Override
    public void bind() throws IOException {
        this.getJavaChannel().socket().bind(new InetSocketAddress(InetAddress.getLocalHost(), this.port));
        this.getJavaChannel().configureBlocking(false);
        log.info("Bound UDP socket at port: {}", this.port);
    }

    /**
     * Writes the pending {@link DatagramPacket} to the underlying channel sending data to the
     * intended receiver of the packet.
     */
    @Override
    protected void doWrite(final Object pendingWrite, final SelectionKey key) throws IOException {
        final DatagramPacket pendingPacket = (DatagramPacket) pendingWrite;
        this.getJavaChannel().send(pendingPacket.getData(), pendingPacket.getReceiver());
    }

    /**
     * Writes the outgoing {@link DatagramPacket} to the channel. The intended receiver of the
     * datagram packet must be set in the <code>data</code> using
     * {@link DatagramPacket#setReceiver(SocketAddress)}.
     */
    @Override
    public void write(final Object data, final SelectionKey key) {
        super.write(data, key);
    }

    /**
     * Container of data used for {@link NioDatagramChannel} to communicate with remote peer.
     */
    @Data
    @RequiredArgsConstructor
    public static class DatagramPacket {
        private final ByteBuffer data;
        private SocketAddress sender;
        private SocketAddress receiver;
    }
}
