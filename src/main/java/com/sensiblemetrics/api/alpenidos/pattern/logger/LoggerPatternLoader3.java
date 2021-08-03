package com.sensiblemetrics.api.alpenidos.pattern.logger;

import java.util.Objects;

public class LoggerPatternLoader3 {

    public interface Logger {
        void log(final String message);
    }

    public interface Filter {
        boolean accept(final String message);
    }

    public static class Loggers {
        public static Logger filterLogger(final Logger logger, final Filter filter) {
            // signature Logger → Filter → Logger
            Objects.requireNonNull(logger);
            Objects.requireNonNull(filter);
            return message -> {
                if (filter.accept(message)) {
                    logger.log(message);
                }
            };
        }
    }

    public static void main(final String[] args) {
        final Logger logger = msg -> System.out.println(msg);
        logger.log("hello");

        final Filter filter = msg -> msg.startsWith("hell");
        final Logger filterLogger = Loggers.filterLogger(logger, filter);
        filterLogger.log("hello");
        filterLogger.log("ok");
    }
}
