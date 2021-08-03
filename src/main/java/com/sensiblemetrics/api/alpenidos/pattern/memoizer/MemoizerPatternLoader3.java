package com.sensiblemetrics.api.alpenidos.pattern.memoizer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.util.stream.IntStream.range;

public class MemoizerPatternLoader3 {

    static <V, R> Function<V, R> memoize(final BiFunction<? super V, Function<? super V, ? extends R>, ? extends R> fun) {
        final Map<V, R> map = new HashMap<>();
        @SuppressWarnings("unchecked") final Function<V, R>[] memoizer = (Function<V, R>[]) new Function<?, ?>[1];
        return memoizer[0] = value -> map.computeIfAbsent(value, v -> fun.apply(v, memoizer[0]));
    }

    public static void main(final String[] args) {
        final Function<Integer, Integer> fibo = memoize((n, fib) -> {
            if (n < 2) {
                return 1;
            }
            return fib.apply(n - 1) + fib.apply(n - 2);
        });

        range(0, 20).map(fibo::apply).forEach(System.out::println);
    }
}
