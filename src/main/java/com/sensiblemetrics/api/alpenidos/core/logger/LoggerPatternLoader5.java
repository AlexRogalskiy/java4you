package com.sensiblemetrics.api.alpenidos.core.logger;

import java.util.Objects;

public class LoggerPatternLoader5 {

    public static void main(final String[] args) {
        final Logger logger = msg -> System.out.println(msg);
        logger.log("hello");

        final FilterLogger filterLogger = new FilterLogger(logger) {
            @Override
            public boolean accept(final String message) {
                return message.startsWith("hell");
            }
        };
        filterLogger.log("hello");
        filterLogger.log("ok");
    }

    interface Logger {
        void log(final String message);
    }

    interface Filter {
        boolean accept(final String message);
    }

    abstract static class FilterLogger implements Logger, Filter {
        private final Logger logger;

        public FilterLogger(final Logger logger) {
            this.logger = Objects.requireNonNull(logger);
        }

        @Override
        public void log(final String message) {
            if (this.accept(message)) {
                logger.log(message);
            }
        }

        @Override
        public abstract boolean accept(final String message);
    }
}
