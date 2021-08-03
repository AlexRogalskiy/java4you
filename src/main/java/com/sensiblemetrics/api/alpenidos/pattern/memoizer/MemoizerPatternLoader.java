package com.sensiblemetrics.api.alpenidos.pattern.memoizer;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.IntStream.range;

public class MemoizerPatternLoader {
    abstract static class Memoizer<V, R> {
        private final Map<V, R> map = new HashMap<>();

        public final R memoize(final V value) {
            return this.map.computeIfAbsent(value, this::compute);
        }

        protected abstract R compute(final V value);
    }

    public static void main(final String[] args) {
        final Memoizer<Integer, Integer> memoizer = new Memoizer<>() {
            @Override
            protected Integer compute(final Integer n) {
                if (n < 2) {
                    return 1;
                }
                return this.memoize(n - 1) + this.memoize(n - 2);
            }
        };

        range(0, 20).map(memoizer::memoize).forEach(System.out::println);
    }
}
