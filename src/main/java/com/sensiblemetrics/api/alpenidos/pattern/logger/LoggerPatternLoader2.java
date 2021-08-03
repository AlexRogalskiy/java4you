package com.sensiblemetrics.api.alpenidos.pattern.logger;

import java.util.Objects;

public class LoggerPatternLoader2 {

    public interface Logger {
        void log(final String message);

        default Logger filter(final Filter filter) {
            // signature Logger → Filter → Logger
            Objects.requireNonNull(filter);
            return message -> {
                if (filter.accept(message)) {
                    log(message);
                }
            };
        }
    }

    public interface Filter {
        boolean accept(final String message);
    }

    public static void main(final String[] args) {
        final Logger logger = msg -> System.out.println(msg);
        logger.log("hello");

        final Filter filter = msg -> msg.startsWith("hell");
        final Logger filterLogger = logger.filter(filter);
        filterLogger.log("hello");
        filterLogger.log("ok");
    }
}
