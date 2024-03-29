package com.sensiblemetrics.api.alpenidos.pattern.reactor;

import com.sensiblemetrics.api.alpenidos.pattern.reactor.framework.NioReactor;
import com.sensiblemetrics.api.alpenidos.pattern.reactor.framework.channel.AbstractNioChannel;
import com.sensiblemetrics.api.alpenidos.pattern.reactor.framework.channel.NioDatagramChannel;
import com.sensiblemetrics.api.alpenidos.pattern.reactor.framework.channel.NioServerSocketChannel;
import com.sensiblemetrics.api.alpenidos.pattern.reactor.framework.dispatcher.Dispatcher;
import com.sensiblemetrics.api.alpenidos.pattern.reactor.framework.dispatcher.ThreadPoolDispatcher;
import com.sensiblemetrics.api.alpenidos.pattern.reactor.framework.handler.ChannelHandler;
import com.sensiblemetrics.api.alpenidos.pattern.reactor.framework.handler.LoggingHandler;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This application demonstrates Reactor pattern. The example demonstrated is a Distributed Logging
 * Service where it listens on multiple TCP or UDP sockets for incoming log requests.
 *
 * <p>
 * <i>INTENT</i> <br>
 * The Reactor design pattern handles service requests that are delivered concurrently to an
 * application by one or more clients. The application can register specific handlers for processing
 * which are called by reactor on specific events.
 *
 * <p>
 * <i>PROBLEM</i> <br>
 * Server applications in a distributed system must handle multiple clients that send them service
 * requests. Following forces need to be resolved:
 * <ul>
 * <li>Availability</li>
 * <li>Efficiency</li>
 * <li>Programming Simplicity</li>
 * <li>Adaptability</li>
 * </ul>
 *
 * <p>
 * <i>PARTICIPANTS</i> <br>
 * <ul>
 * <li>Synchronous Event De-multiplexer
 * <p>
 * {@link NioReactor} plays the role of synchronous event de-multiplexer.
 * It waits for events on multiple channels registered to it in an event loop.
 * </p>
 * </li>
 * <li>Initiation Dispatcher
 * <p>
 * {@link NioReactor} plays this role as the application specific {@link ChannelHandler}s
 * are registered to the reactor.
 * </p>
 * </li>
 * <li>Handle
 * <p>
 * {@link AbstractNioChannel} acts as a handle that is registered to the reactor.
 * When any events occur on a handle, reactor calls the appropriate handler.
 * </p>
 * </li>
 * <li>Event Handler
 * <p>
 * {@link ChannelHandler} acts as an event handler, which is bound to a
 * channel and is called back when any event occurs on any of its associated handles. Application
 * logic resides in event handlers.
 * </p>
 * </li>
 * </ul>
 * The application utilizes single thread to listen for requests on all ports. It does not create a
 * separate thread for each client, which provides better scalability under load (number of clients
 * increase).
 * The example uses Java NIO framework to implement the Reactor.
 */
@RequiredArgsConstructor
public class ReactorPatternLoader {
    private List<AbstractNioChannel> channels = new ArrayList<>();
    private final Dispatcher dispatcher;
    private NioReactor reactor;

    /**
     * ReactorPatternLoader entry.
     */
    public static void main(final String[] args) throws IOException {
        new ReactorPatternLoader(new ThreadPoolDispatcher(2)).start();
    }

    /**
     * Starts the NIO reactor.
     *
     * @throws IOException if any channel fails to bind.
     */
    public void start() throws IOException {
        /*
         * The application can customize its event dispatching mechanism.
         */
        this.reactor = new NioReactor(this.dispatcher);

        /*
         * This represents application specific business logic that dispatcher will call on appropriate
         * events. These events are read events in our example.
         */
        final LoggingHandler loggingHandler = new LoggingHandler();

        /*
         * Our application binds to multiple channels and uses same logging handler to handle incoming
         * log requests.
         */
        this.reactor
            .registerChannel(tcpChannel(6666, loggingHandler))
            .registerChannel(tcpChannel(6667, loggingHandler))
            .registerChannel(udpChannel(6668, loggingHandler))
            .start();
    }

    /**
     * Stops the NIO reactor. This is a blocking call.
     *
     * @throws InterruptedException if interrupted while stopping the reactor.
     * @throws IOException          if any I/O error occurs
     */
    public void stop() throws InterruptedException, IOException {
        this.reactor.stop();
        this.dispatcher.stop();
        this.channels.forEach(this::close);
    }

    private void close(final AbstractNioChannel channel) {
        try {
            channel.getJavaChannel().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private AbstractNioChannel tcpChannel(final int port, ChannelHandler handler) throws IOException {
        final NioServerSocketChannel channel = new NioServerSocketChannel(port, handler);
        channel.bind();
        this.channels.add(channel);
        return channel;
    }

    private AbstractNioChannel udpChannel(final int port, final ChannelHandler handler) throws IOException {
        final NioDatagramChannel channel = new NioDatagramChannel(port, handler);
        channel.bind();
        this.channels.add(channel);
        return channel;
    }
}
