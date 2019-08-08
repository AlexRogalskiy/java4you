package com.sensiblemetrics.api.alpenidos.core.concurrent_server;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * A concurrent server thread that processes the requests sent by the clients.
 */
@Slf4j
@RequiredArgsConstructor
public class ServerThread extends Thread {
    /**
     * Socket where the client is connected
     */
    private final Socket clientSocket;

    /**
     * Thread id
     */
    private final int id;

    public void run() {
        log.info("New thread start: " + id);
        try {
            final PrintWriter pw = new PrintWriter(this.clientSocket.getOutputStream(), true); //Print writer for respones
            final BufferedReader br = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream())); //Buffered reader for client messages
            process(br, pw);
            pw.close();
            br.close();
            this.clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void process(BufferedReader pIn, PrintWriter pOut) throws IOException {
        String inputLine;
        String outputLine;
        int state = 0;

        //As the client follows the communication protocol, the server advances to the next state, until it finishes it execution
        while (state < 3 && (inputLine = pIn.readLine()) != null) {
            log.info("Process entry: " + inputLine);
            switch (state) {
                case 0:
                    if (inputLine.equalsIgnoreCase("Hello")) {
                        outputLine = "Hey there";
                        state++;
                    } else {
                        outputLine = "ERROR. Expected 'Hello'";
                        state = 0;
                    }
                    break;
                case 1:
                    try {
                        int val = Integer.parseInt(inputLine);
                        val--;
                        outputLine = "" + val;
                        state++;
                    } catch (Exception e) {
                        outputLine = "ERROR int the expected value";
                        state = 0;
                    }
                    break;
                case 2:
                    if (inputLine.equalsIgnoreCase("Goodbye")) {
                        outputLine = "See you later!";
                        state++;
                    } else {
                        outputLine = "ERROR. Expected 'Goodbye'";
                        state = 0;
                    }
                    break;
                default:
                    outputLine = "ERROR";
                    state = 0;
            }
            pOut.println(outputLine);
        }
    }
}
