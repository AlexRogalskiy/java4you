package com.sensiblemetrics.api.alpenidos.pattern.stack_machine.impl;

import java.io.*;

public class IO {
    private BufferedReader in;
    private PrintStream out;
    private PrintStream err;

    public IO(final InputStream inStream, final OutputStream outStream, final OutputStream errStream) {
        this.in = new BufferedReader(new InputStreamReader(inStream));
        this.out = new PrintStream(outStream);
        this.err = new PrintStream(errStream);
    }

    public void displayRuntimeError(final String string) {
        this.err.println(string);
    }

    public void displayProgramTermination() {
        this.out.println("(HALT)");
    }

    public int read() throws IOException {
        this.out.print("? ");
        final String line = this.in.readLine();
        this.out.println();
        return Integer.parseInt(line);
    }

    public void write(int op) {
        this.out.println("> " + op);
    }
}
