package com.sensiblemetrics.api.alpenidos.pattern.two_phase_termination;

import java.net.Socket;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * <p>
 * Date: Aug 19, 2011
 *
 * @author moleksyuk
 */
public class Session implements Runnable {
    private Thread myThread;
    private Portfolio portfolio;
    private Socket mySocket;

    public Session(final Socket socket) {
        this.myThread = new Thread(this);
        this.mySocket = socket;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Runnable#run()
     */
    @SuppressWarnings("static-access")
    @Override
    public void run() {
        this.initialize();
        while (!this.myThread.interrupted()) {
            this.portfolio.sendTransactionsToClient(this.mySocket);
        }
        shutDown();
    }

    public void interrupt() {
        this.myThread.interrupt();
    }

    private void initialize() {
    }

    private void shutDown() {
    }
}
