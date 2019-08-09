package com.sensiblemetrics.api.alpenidos.core.adapter3;

public class AdapterPatternLoader2 {

    public interface Logger {
        void log(final String message);
    }

    public enum Level {WARNING, ERROR}

    public interface Logger2 {
        void log(final Level level, final String message);

        default Logger level(final Level level) {
            return msg -> this.log(level, msg);
        }
    }

    public static void main(final String[] args) {
        final Logger2 logger2 = (level, msg) -> System.out.println(level + " " + msg);
        logger2.log(Level.ERROR, "abort abort !");

        logger2.level(Level.ERROR).log("abort abort !");
    }
}
