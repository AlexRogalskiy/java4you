package com.sensiblemetrics.api.alpenidos.core.state2;

import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

public class StatePatternLoader4 {

    interface Logger {
        enum Level {ERROR, WARNING}

        void error(final String message);

        void warning(final String message);

        Logger quiet();

        Logger chatty();
    }

    static class Loggers {
        static Logger logger(final Consumer<? super String> printer) {
            return new ChattyLogger(printer);
        }
    }

    @RequiredArgsConstructor
    static class ChattyLogger implements Logger {
        private final Consumer<? super String> printer;

        @Override
        public void error(final String message) {
            this.printer.accept(message);
        }

        @Override
        public void warning(final String message) {
            this.printer.accept(message);
        }

        @Override
        public Logger quiet() {
            return new ChattyLogger(this.printer) {
                @Override
                public void warning(String message) {
                    // empty
                }

                @Override
                public Logger quiet() {
                    return this;
                }

                @Override
                public Logger chatty() {
                    return ChattyLogger.this;
                }
            };
        }

        @Override
        public Logger chatty() {
            return this;
        }
    }

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
}
