package com.sensiblemetrics.api.alpenidos.pattern.reactor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Represents the clients of Reactor pattern. Multiple clients are run concurrently and send logging
 * requests to Reactor.
 */
@Slf4j
public class ReactorClientPatternLoader {
    private final ExecutorService service = Executors.newFixedThreadPool(4);

    /**
     * ReactorPatternLoader client entry.
     *
     * @throws IOException if any I/O error occurs.
     */
    public static void main(final String[] args) throws IOException {
        final ReactorClientPatternLoader appClient = new ReactorClientPatternLoader();
        appClient.start();
    }

    /**
     * Starts the logging clients.
     *
     * @throws IOException if any I/O error occurs.
     */
    public void start() throws IOException {
        log.info("Starting logging clients");
        this.service.execute(new TcpLoggingClient("SimpleFactoryPatternLoader 1", 6666));
        this.service.execute(new TcpLoggingClient("SimpleFactoryPatternLoader 2", 6667));
        this.service.execute(new UdpLoggingClient("SimpleFactoryPatternLoader 3", 6668));
        this.service.execute(new UdpLoggingClient("SimpleFactoryPatternLoader 4", 6668));
    }

    /**
     * Stops logging clients. This is a blocking call.
     */
    public void stop() {
        this.service.shutdown();
        if (!this.service.isTerminated()) {
            this.service.shutdownNow();
            try {
                this.service.awaitTermination(1000, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                log.error("exception awaiting termination", e);
            }
        }
        log.info("Logging clients stopped");
    }

    private static void artificialDelayOf(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("sleep interrupted", e);
        }
    }

    /**
     * A logging client that sends requests to Reactor on TCP socket.
     */
    @RequiredArgsConstructor
    public static class TcpLoggingClient implements Runnable {
        private final String clientName;
        private final int serverPort;

        @Override
        public void run() {
            try (final Socket socket = new Socket(InetAddress.getLocalHost(), this.serverPort)) {
                final OutputStream outputStream = socket.getOutputStream();
                final PrintWriter writer = new PrintWriter(outputStream);
                this.sendLogRequests(writer, socket.getInputStream());
            } catch (IOException e) {
                log.error("error sending requests", e);
                throw new RuntimeException(e);
            }
        }

        private void sendLogRequests(PrintWriter writer, InputStream inputStream) throws IOException {
            for (int i = 0; i < 4; i++) {
                writer.println(clientName + " - Log request: " + i);
                writer.flush();

                final byte[] data = new byte[1024];
                final int read = inputStream.read(data, 0, data.length);
                if (read == 0) {
                    log.info("Read zero bytes");
                } else {
                    log.info(new String(data, 0, read));
                }
                artificialDelayOf(100);
            }
        }

    }

    /**
     * A logging client that sends requests to Reactor on UDP socket.
     */
    public static class UdpLoggingClient implements Runnable {
        private final String clientName;
        private final InetSocketAddress remoteAddress;

        /**
         * Creates a new UDP logging client.
         *
         * @param clientName the name of the client to be sent in logging requests.
         * @param port       the port on which client will send logging requests.
         * @throws UnknownHostException if localhost is unknown
         */
        public UdpLoggingClient(final String clientName, final int port) throws UnknownHostException {
            this.clientName = clientName;
            this.remoteAddress = new InetSocketAddress(InetAddress.getLocalHost(), port);
        }

        @Override
        public void run() {
            try (final DatagramSocket socket = new DatagramSocket()) {
                for (int i = 0; i < 4; i++) {
                    final String message = clientName + " - Log request: " + i;
                    final DatagramPacket request = new DatagramPacket(message.getBytes(), message.getBytes().length, remoteAddress);
                    socket.send(request);

                    final byte[] data = new byte[1024];
                    final DatagramPacket reply = new DatagramPacket(data, data.length);
                    socket.receive(reply);
                    if (reply.getLength() == 0) {
                        log.info("Read zero bytes");
                    } else {
                        log.info(new String(reply.getData(), 0, reply.getLength()));
                    }
                    artificialDelayOf(100);
                }
            } catch (IOException e1) {
                log.error("error sending packets", e1);
            }
        }
    }
}
