package com.sensiblemetrics.api.alpenidos.pattern.state2;

import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.function.Function.identity;

public class StatePatternLoader2 {

    static class Logger {
        enum Level {ERROR, WARNING}

        private final Consumer<? super String> error;
        private final Consumer<? super String> warning;
        private final Logger quiet;
        private final Logger chatty;

        private Logger(final Consumer<? super String> error,
                       final Consumer<? super String> warning,
                       final Function<Logger, Logger> quietFactory,
                       final Function<Logger, Logger> chattyFactory) {
            this.error = error;
            this.warning = warning;
            this.quiet = quietFactory.apply(this);
            this.chatty = chattyFactory.apply(this);
        }

        public void error(final String message) {
            this.error.accept(message);
        }

        public void warning(final String message) {
            this.warning.accept(message);
        }

        public Logger quiet() {
            return this.quiet;
        }

        public Logger chatty() {
            return this.chatty;
        }

        public static Logger logger(final Consumer<? super String> consumer) {
            return new Logger(consumer,
                consumer,
                normal -> new Logger(consumer, msg -> { /* empty */ }, identity(), it -> normal),
                identity());
        }
    }

    public static void main(final String[] args) {
        final Logger logger = Logger.logger(System.out::println);
        logger.error("ERROR");
        logger.warning("WARNING");

        final Logger quiet = logger.quiet();
        quiet.error("ERROR");
        quiet.warning("WARNING");

        final Logger logger2 = quiet.chatty();
        logger2.error("ERROR");
        logger2.warning("WARNING");
    }
}
