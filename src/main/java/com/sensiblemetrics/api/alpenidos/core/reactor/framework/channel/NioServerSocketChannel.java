package com.sensiblemetrics.api.alpenidos.core.reactor.framework.channel;

import com.sensiblemetrics.api.alpenidos.core.reactor.framework.handler.ChannelHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * A wrapper over {@link NioServerSocketChannel} which can read and write data on a
 * {@link SocketChannel}.
 */
@Slf4j
public class NioServerSocketChannel extends AbstractNioChannel {
    private final int port;

    /**
     * Creates a {@link ServerSocketChannel} which will bind at provided port and use
     * <code>handler</code> to handle incoming events on this channel.
     * <p>
     * Note the constructor does not bind the socket, {@link #bind()} method should be called for
     * binding the socket.
     *
     * @param port    the port on which channel will be bound to accept incoming connection requests.
     * @param handler the handler that will handle incoming requests on this channel.
     * @throws IOException if any I/O error occurs.
     */
    public NioServerSocketChannel(final int port, final ChannelHandler handler) throws IOException {
        super(handler, ServerSocketChannel.open());
        this.port = port;
    }


    @Override
    public int getInterestedOps() {
        // being a server socket channel it is interested in accepting connection from remote peers.
        return SelectionKey.OP_ACCEPT;
    }

    /**
     * @return the underlying {@link ServerSocketChannel}.
     */
    @Override
    public ServerSocketChannel getJavaChannel() {
        return (ServerSocketChannel) super.getJavaChannel();
    }

    /**
     * Reads and returns {@link ByteBuffer} from the underlying {@link SocketChannel} represented by
     * the <code>key</code>. Due to the fact that there is a dedicated channel for each client
     * connection we don't need to store the sender.
     */
    @Override
    public ByteBuffer read(final SelectionKey key) throws IOException {
        final SocketChannel socketChannel = (SocketChannel) key.channel();
        final ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = socketChannel.read(buffer);
        buffer.flip();
        if (read == -1) {
            throw new IOException("Socket closed");
        }
        return buffer;
    }

    /**
     * Binds TCP socket on the provided <code>port</code>.
     *
     * @throws IOException if any I/O error occurs.
     */
    @Override
    public void bind() throws IOException {
        this.getJavaChannel().socket().bind(new InetSocketAddress(InetAddress.getLocalHost(), this.port));
        this.getJavaChannel().configureBlocking(false);
        log.info("Bound TCP socket at port: {}", this.port);
    }

    /**
     * Writes the pending {@link ByteBuffer} to the underlying channel sending data to the intended
     * receiver of the packet.
     */
    @Override
    protected void doWrite(final Object pendingWrite, final SelectionKey key) throws IOException {
        final ByteBuffer pendingBuffer = (ByteBuffer) pendingWrite;
        ((SocketChannel) key.channel()).write(pendingBuffer);
    }
}
