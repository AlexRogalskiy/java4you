package com.sensiblemetrics.api.alpenidos.core.logger;

public class LoggerPatternLoader6 {

    public interface Logger {
        void log(final String message);
    }

    public static void main(final String[] args) {
        final Logger logger = msg -> System.out.println(msg);
        logger.log("hello");
    }
}
