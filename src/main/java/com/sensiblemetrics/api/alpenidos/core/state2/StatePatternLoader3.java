package com.sensiblemetrics.api.alpenidos.core.state2;

public class StatePatternLoader3 {

    interface Logger {
        enum Level {ERROR, WARNING}

        void error(final String message);

        default void warning(final String message) {
            this.error(message);
        }

        interface QuietLogger extends Logger {
            @Override
            default void warning(final String message) {
            }

            @Override
            default Logger quiet() {
                return this;
            }

            @Override
            default Logger chatty() {
                //return msg -> error(msg);
                return this::error;
            }
        }

        default Logger quiet() {
            //return (QuietLogger)msg -> error(msg);
            return (QuietLogger) this::error;
        }

        default Logger chatty() {
            return this;
        }
    }

    public static void main(final String[] args) {
        final Logger logger = System.out::println;
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
