package com.sensiblemetrics.api.alpenidos.pattern.command3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static java.util.Arrays.stream;

public class CommandPatternLoader2 {

    interface OptionBuilder {
        void register(final String name, final String description, final Runnable action);
    }

    interface Context {
        void help();
    }

    interface CommandLineParser {
        void parse(final String[] args);

        static CommandLineParser create(final BiConsumer<OptionBuilder, Context> consumer) {
            final StringBuilder help = new StringBuilder();
            final Context context = () -> System.out.println(help);
            final Map<String, Runnable> actionMap = new HashMap<>();
            consumer.accept((name, description, action) -> {
                actionMap.put('-' + name, action);
                help.append(name).append(": ").append(description).append('\n');
            }, context);
            return args ->
                stream(args)
                    .filter(arg -> arg.startsWith("-"))
                    .map(arg -> actionMap.getOrDefault(arg, () -> {
                        context.help();
                        System.exit(1);
                    }))
                    .forEach(Runnable::run);
        }
    }

    public static void main(final String[] args) {
        CommandLineParser.create((opt, ctx) -> {
            opt.register("a", "print all info",
                () -> System.out.println("see -a"));
            opt.register("help", "print this help", ctx::help);
        }).parse(args);
    }
}
