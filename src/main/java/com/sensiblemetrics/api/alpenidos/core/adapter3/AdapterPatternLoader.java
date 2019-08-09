package com.sensiblemetrics.api.alpenidos.core.adapter3;

public class AdapterPatternLoader {

    interface Logger {
        void log(final String message);
    }

    enum Level {WARNING, ERROR}

    interface Logger2 {
        void log(final Level level, final String message);
    }

    public static void main(final String[] args) {
        final Logger2 logger2 = (level, msg) -> System.out.println(level + " " + msg);
        logger2.log(Level.ERROR, "abort abort !");

        final Logger logger = msg -> System.out.println(msg);
        logger.log("test");
    }
}
