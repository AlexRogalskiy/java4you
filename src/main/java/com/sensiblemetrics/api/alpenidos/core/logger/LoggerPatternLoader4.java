package com.sensiblemetrics.api.alpenidos.core.logger;

import java.util.Objects;

public class LoggerPatternLoader4 {

    public static void main(final String[] args) {
        final Logger logger = msg -> System.out.println(msg);
        logger.log("hello");

        final Filter filter = msg -> msg.startsWith("hell");
        final FilterLogger filterLogger = new FilterLogger(logger, filter);
        filterLogger.log("hello");
        filterLogger.log("ok");
    }

    public interface Logger {
        void log(final String message);
    }

    public interface Filter {
        boolean accept(final String message);
    }

    public static class FilterLogger implements Logger {
        private final Logger logger;
        private final Filter filter;

        public FilterLogger(final Logger logger, final Filter filter) {
            this.logger = Objects.requireNonNull(logger);
            this.filter = Objects.requireNonNull(filter);
        }

        @Override
        public void log(final String message) {
            if (filter.accept(message)) {
                logger.log(message);
            }
        }
    }
}
