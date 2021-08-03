package com.sensiblemetrics.api.alpenidos.pattern.concurrent_server;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Class that represents a client that sends requests to a server.
 */
@Slf4j
public class Client {

    /**
     * Client's IP address
     */
    public final static String CLIENT_IP = "localhost";

    public static void main(final String args[]) {
        boolean execute = true;
        Socket socket = null;
        PrintWriter pw = null;
        BufferedReader br = null;

        try {
            socket = new Socket(CLIENT_IP, 80);
            pw = new PrintWriter(socket.getOutputStream(), true); //Print Writer that sends the message to the server
            br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //Server response BufferedReader
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            System.exit(1);
        }

        final BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)); //Console input BufferedReader
        String fromServer;
        String fromUser;

        while (execute) {
            log.info("Write a message: ");
            try {
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    log.info("ConcurrentServer.Client: " + fromUser);
                    if (fromUser.equalsIgnoreCase("Goodbye")) {
                        execute = false;
                    }
                    pw.println(fromUser);
                }

                if ((fromServer = br.readLine()) != null) {
                    log.info("Server: " + fromServer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            pw.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
