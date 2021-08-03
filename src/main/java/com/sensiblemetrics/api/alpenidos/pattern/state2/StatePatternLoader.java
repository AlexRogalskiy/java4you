package com.sensiblemetrics.api.alpenidos.pattern.state2;

import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

public class StatePatternLoader {

    public static void main(final String[] args) {
        final Logger logger = Loggers.logger(msg -> System.out.println(msg));
        logger.error("ERROR");
        logger.warning("WARNING");

        final Logger quiet = logger.quiet();
        quiet.error("ERROR");
        quiet.warning("WARNING");

        final Logger logger2 = quiet.chatty();
        logger2.error("ERROR");
        logger2.warning("WARNING");
    }

    interface Logger {
        void error(final String message);

        void warning(final String message);

        Logger quiet();

        Logger chatty();

        enum Level {ERROR, WARNING}
    }

    static class Loggers {
        static Logger logger(final Consumer<String> printer) {
            return new ChattyLogger(printer);
        }
    }

    @RequiredArgsConstructor
    static class ChattyLogger implements Logger {
        private final Consumer<String> printer;

        @Override
        public void error(final String message) {
            this.printer.accept(message);
        }

        @Override
        public void warning(final String message) {
            printer.accept(message);
        }

        @Override
        public Logger quiet() {
            return new QuietLogger(this.printer);
        }

        @Override
        public Logger chatty() {
            return this;
        }
    }

    @RequiredArgsConstructor
    static class QuietLogger implements Logger {
        private final Consumer<String> printer;

        @Override
        public void error(final String message) {
            this.printer.accept(message);
        }

        @Override
        public void warning(final String message) {
        }

        @Override
        public Logger quiet() {
            return this;
        }

        @Override
        public Logger chatty() {
            return new ChattyLogger(this.printer);
        }
    }
}
