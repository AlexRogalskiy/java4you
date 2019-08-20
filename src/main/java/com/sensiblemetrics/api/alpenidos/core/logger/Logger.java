package com.sensiblemetrics.api.alpenidos.core.logger;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;

    private final FileWriter fileWriter;

    private Logger(Builder builder) {
        fileWriter = builder.fileWriter;
    }

    public synchronized static Logger get() throws IOException {
        if (instance == null) {
            new Builder().build();
        }
        return instance;
    }

    public void out(final String text) throws IOException {
        System.out.println(text);

        if (fileWriter != null) {
            fileWriter.write(text);
        }
    }

    public void err(final String text) throws IOException {
        System.err.println(text);

        if (fileWriter != null) {
            fileWriter.write(text);
        }
    }

    public void close() throws IOException {
        if (fileWriter != null) {
            fileWriter.close();
        }
    }

    public static final class Builder {
        private FileWriter fileWriter;

        public Builder() {
        }

        public Builder withFileWriter(FileWriter val) {
            fileWriter = val;
            return this;
        }

        public void build() throws IOException {
            if (instance != null) {
                instance.close();
            }
            instance = new Logger(this);
        }
    }
}
