package com.sensiblemetrics.api.alpenidos.pattern.memoizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.util.stream.IntStream.range;

public class MemoizerPatternLoader4 {

    public static class Memoizer<V, R> {
        private final BiFunction<? super V, Function<? super V, ? extends R>, ? extends R> function;
        private final Map<V, R> map = new HashMap<>();

        public Memoizer(final BiFunction<? super V, Function<? super V, ? extends R>, ? extends R> function) {
            this.function = Objects.requireNonNull(function);
        }

        public final R memoize(final V value) {
            return this.map.computeIfAbsent(value, v -> this.function.apply(v, this::memoize));
        }
    }

    public static void main(final String[] args) {
        final Memoizer<Integer, Integer> fibo = new Memoizer<>((n, fib) -> {
            if (n < 2) {
                return 1;
            }
            return fib.apply(n - 1) + fib.apply(n - 2);
        });

        range(0, 20).map(fibo::memoize).forEach(System.out::println);
    }
}
