package com.sensiblemetrics.api.alpenidos.pattern.reactor.framework;

import com.sensiblemetrics.api.alpenidos.pattern.reactor.framework.channel.AbstractNioChannel;
import com.sensiblemetrics.api.alpenidos.pattern.reactor.framework.dispatcher.Dispatcher;
import com.sensiblemetrics.api.alpenidos.pattern.reactor.framework.handler.ChannelHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * This class acts as Synchronous Event De-multiplexer and Initiation Dispatcher of Reactor pattern. Multiple handles
 * i.e. {@link AbstractNioChannel}s can be registered to the reactor and it blocks for events from all these handles.
 * Whenever an event occurs on any of the registered handles, it synchronously de-multiplexes the event which can be any
 * of read, write or accept, and dispatches the event to the appropriate {@link ChannelHandler} using the
 * {@link Dispatcher}.
 *
 * <p>
 * Implementation: A NIO reactor runs in its own thread when it is started using {@link #start()} method.
 * {@link NioReactor} uses {@link Selector} for realizing Synchronous Event De-multiplexing.
 *
 * <p>
 * NOTE: This is one of the ways to implement NIO reactor and it does not take care of all possible edge cases which are
 * required in a real application. This implementation is meant to demonstrate the fundamental concepts that lie behind
 * Reactor pattern.
 */
@Slf4j
public class NioReactor {

    private final Selector selector;
    private final Dispatcher dispatcher;
    /**
     * All the work of altering the SelectionKey operations and Selector operations are performed in the context of main
     * event loop of reactor. So when any channel needs to change its readability or writability, a new command is added
     * in the command queue and then the event loop picks up the command and executes it in next iteration.
     */
    private final Queue<Runnable> pendingCommands = new ConcurrentLinkedQueue<>();
    private final ExecutorService reactorMain = Executors.newSingleThreadExecutor();

    /**
     * Creates a reactor which will use provided {@code dispatcher} to dispatch events. The application can provide
     * various implementations of dispatcher which suits its needs.
     *
     * @param dispatcher a non-null dispatcher used to dispatch events on registered channels.
     * @throws IOException if any I/O error occurs.
     */
    public NioReactor(final Dispatcher dispatcher) throws IOException {
        this.dispatcher = dispatcher;
        this.selector = Selector.open();
    }

    /**
     * Starts the reactor event loop in a new thread.
     */
    public void start() {
        reactorMain.execute(() -> {
            try {
                log.info("Reactor started, waiting for events...");
                this.eventLoop();
            } catch (IOException e) {
                log.error("exception in event loop", e);
            }
        });
    }

    /**
     * Stops the reactor and related resources such as dispatcher.
     *
     * @throws InterruptedException if interrupted while stopping the reactor.
     * @throws IOException          if any I/O error occurs.
     */
    public void stop() throws InterruptedException, IOException {
        this.reactorMain.shutdownNow();
        this.selector.wakeup();
        this.reactorMain.awaitTermination(4, TimeUnit.SECONDS);
        this.selector.close();
        log.info("Reactor stopped");
    }

    /**
     * Registers a new channel (handle) with this reactor. Reactor will start waiting for events on this channel and
     * notify of any events. While registering the channel the reactor uses {@link AbstractNioChannel#getInterestedOps()}
     * to know about the interested operation of this channel.
     *
     * @param channel a new channel on which reactor will wait for events. The channel must be bound prior to being registered.
     * @return this
     * @throws IOException if any I/O error occurs.
     */
    public NioReactor registerChannel(final AbstractNioChannel channel) throws IOException {
        final SelectionKey key = channel.getJavaChannel().register(this.selector, channel.getInterestedOps());
        key.attach(channel);
        channel.setReactor(this);
        return this;
    }

    private void eventLoop() throws IOException {
        while (true) {
            // honor interrupt request
            if (Thread.interrupted()) {
                break;
            }
            // honor any pending commands first
            this.processPendingCommands();
            /*
             * Synchronous event de-multiplexing happens here, this is blocking call which returns when it is possible to
             * initiate non-blocking operation on any of the registered channels.
             */
            this.selector.select();

            /*
             * Represents the events that have occurred on registered handles.
             */
            final Set<SelectionKey> keys = this.selector.selectedKeys();
            final Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                final SelectionKey key = iterator.next();
                if (!key.isValid()) {
                    iterator.remove();
                    continue;
                }
                this.processKey(key);
            }
            keys.clear();
        }
    }

    private void processPendingCommands() {
        final Iterator<Runnable> iterator = this.pendingCommands.iterator();
        while (iterator.hasNext()) {
            final Runnable command = iterator.next();
            command.run();
            iterator.remove();
        }
    }

    /*
     * Initiation dispatcher logic, it checks the type of event and notifier application specific event handler to handle
     * the event.
     */
    private void processKey(final SelectionKey key) throws IOException {
        if (key.isAcceptable()) {
            this.onChannelAcceptable(key);
        } else if (key.isReadable()) {
            this.onChannelReadable(key);
        } else if (key.isWritable()) {
            onChannelWritable(key);
        }
    }

    private static void onChannelWritable(final SelectionKey key) throws IOException {
        final AbstractNioChannel channel = (AbstractNioChannel) key.attachment();
        channel.flush(key);
    }

    private void onChannelReadable(final SelectionKey key) {
        try {
            // reads the incoming data in context of reactor main loop. Can this be improved?
            final Object readObject = ((AbstractNioChannel) key.attachment()).read(key);
            this.dispatchReadEvent(key, readObject);
        } catch (IOException e) {
            try {
                key.channel().close();
            } catch (IOException e1) {
                log.error("error closing channel", e1);
            }
        }
    }

    /*
     * Uses the application provided dispatcher to dispatch events to application handler.
     */
    private void dispatchReadEvent(final SelectionKey key, final Object readObject) {
        this.dispatcher.onChannelReadEvent((AbstractNioChannel) key.attachment(), readObject, key);
    }

    private void onChannelAcceptable(final SelectionKey key) throws IOException {
        final ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        final SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);

        final SelectionKey readKey = socketChannel.register(this.selector, SelectionKey.OP_READ);
        readKey.attach(key.attachment());
    }

    /**
     * Queues the change of operations request of a channel, which will change the interested operations of the channel
     * sometime in future.
     * <p>
     * This is a non-blocking method and does not guarantee that the operations have changed when this method returns.
     *
     * @param key           the key for which operations have to be changed.
     * @param interestedOps the new interest operations.
     */
    public void changeOps(final SelectionKey key, final int interestedOps) {
        this.pendingCommands.add(new ChangeKeyOpsCommand(key, interestedOps));
        this.selector.wakeup();
    }

    /**
     * A command that changes the interested operations of the key provided.
     */
    public class ChangeKeyOpsCommand implements Runnable {
        private SelectionKey key;
        private int interestedOps;

        public ChangeKeyOpsCommand(final SelectionKey key, final int interestedOps) {
            this.key = key;
            this.interestedOps = interestedOps;
        }

        public void run() {
            this.key.interestOps(this.interestedOps);
        }

        @Override
        public String toString() {
            return "Change of ops to: " + interestedOps;
        }
    }
}
