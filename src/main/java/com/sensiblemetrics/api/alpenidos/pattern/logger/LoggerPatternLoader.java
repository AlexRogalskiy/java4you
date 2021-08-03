package com.sensiblemetrics.api.alpenidos.pattern.logger;

import java.util.Objects;
import java.util.function.Predicate;

public class LoggerPatternLoader {

    public interface Logger {
        void log(final String message);

        default Logger filter(final Predicate<? super String> filter) {
            // signature Logger → Predicate → Logger
            Objects.requireNonNull(filter);
            return message -> {
                if (filter.test(message)) {
                    log(message);
                }
            };
        }
    }

    public static void main(final String[] args) {
        final Logger logger = msg -> System.out.println(msg);
        logger.log("hello");

        final Predicate<String> filter = msg -> msg.startsWith("hell");
        final Logger filterLogger = logger.filter(filter);
        filterLogger.log("hello");
        filterLogger.log("ok");
    }
}
