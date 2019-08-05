package com.sensiblemetrics.api.alpenidos.core.reactor.framework.handler;

import com.sensiblemetrics.api.alpenidos.core.reactor.framework.channel.AbstractNioChannel;
import com.sensiblemetrics.api.alpenidos.core.reactor.framework.channel.NioDatagramChannel;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;

/**
 * Logging server application logic. It logs the incoming requests on standard console and returns a
 * canned acknowledgement back to the remote peer.
 */
@Slf4j
public class LoggingHandler implements ChannelHandler {

    private static final byte[] ACK = "Data logged successfully".getBytes();

    /**
     * Decodes the received data and logs it on standard console.
     */
    @Override
    public void handleChannelRead(final AbstractNioChannel channel, final Object readObject, final SelectionKey key) {
        /*
         * As this handler is attached with both TCP and UDP channels we need to check whether the data
         * received is a ByteBuffer (from TCP channel) or a DatagramPacket (from UDP channel).
         */
        if (readObject instanceof ByteBuffer) {
            doLogging((ByteBuffer) readObject);
            sendReply(channel, key);
        } else if (readObject instanceof NioDatagramChannel.DatagramPacket) {
            final NioDatagramChannel.DatagramPacket datagram = (NioDatagramChannel.DatagramPacket) readObject;
            doLogging(datagram.getData());
            sendReply(channel, datagram, key);
        } else {
            throw new IllegalStateException("Unknown data received");
        }
    }

    private static void sendReply(final AbstractNioChannel channel, final NioDatagramChannel.DatagramPacket incomingPacket, final SelectionKey key) {
        /*
         * Create a reply acknowledgement datagram packet setting the receiver to the sender of incoming
         * message.
         */
        final NioDatagramChannel.DatagramPacket replyPacket = new NioDatagramChannel.DatagramPacket(ByteBuffer.wrap(ACK));
        replyPacket.setReceiver(incomingPacket.getSender());
        channel.write(replyPacket, key);
    }

    private static void sendReply(final AbstractNioChannel channel, final SelectionKey key) {
        final ByteBuffer buffer = ByteBuffer.wrap(ACK);
        channel.write(buffer, key);
    }

    private static void doLogging(final ByteBuffer data) {
        log.info(new String(data.array(), 0, data.limit()));
    }
}
