package com.sensiblemetrics.api.alpenidos.pattern.command3;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.Objects.requireNonNull;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class CommandPatternLoader3 {

    enum Option {
        ALL("a", "print all info", () -> System.out.println("see -a")),
        HELP("help", "print this help", () -> stream(values()).forEach(System.out::println));

        private final String name;
        private final String description;
        private final Runnable action;

        Option(String name, String description, Runnable action) {
            this.name = requireNonNull(name);
            this.description = requireNonNull(description);
            this.action = requireNonNull(action);
        }

        @Override
        public String toString() {
            return this.name + ": " + this.description;
        }

        public static void parse(final String[] args) {
            for (final String arg : args) {
                if (arg.startsWith("-")) {
                    final Option option = OPTION_MAP.getOrDefault(arg, HELP);
                    if (option == null) {
                        HELP.action.run();
                        return;
                    }
                    option.action.run();
                }
            }
        }

        private static final Map<String, Option> OPTION_MAP = stream(values()).collect(toMap(opt -> '-' + opt.name, identity()));
    }

    public static void main(final String[] args) {
        Option.parse(args);
    }
}
