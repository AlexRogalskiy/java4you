package com.sensiblemetrics.api.alpenidos.pattern.command3;

import lombok.Getter;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.Objects.requireNonNull;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class CommandPatternLoader {

    @Getter
    enum Option {
        ALL("a", "print all info") {
            @Override
            void perform() {
                System.out.println("see -a");
            }
        },
        HELP("help", "print this help") {
            @Override
            void perform() {
                stream(values()).forEach(System.out::println);
            }
        };

        private final String name;
        private final String description;

        private Option(String name, String description) {
            this.name = requireNonNull(name);
            this.description = requireNonNull(description);
        }

        abstract void perform();

        @Override
        public String toString() {
            return this.name + ": " + this.description;
        }

        public static void parse(final String[] args) {
            for (final String arg : args) {
                if (arg.startsWith("-")) {
                    final Option option = OPTION_MAP.get(arg);
                    if (option == null) {
                        HELP.perform();
                        System.exit(1);
                        return;
                    }
                    option.perform();
                }
            }
        }

        private static final Map<String, Option> OPTION_MAP = stream(values()).collect(toMap(opt -> '-' + opt.name, identity()));
    }

    public static void main(final String[] args) {
        Option.parse(args);
    }
}
