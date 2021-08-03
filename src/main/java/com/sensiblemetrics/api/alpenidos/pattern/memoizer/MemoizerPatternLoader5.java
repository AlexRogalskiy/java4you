package com.sensiblemetrics.api.alpenidos.pattern.memoizer;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Objects;
import java.util.function.Function;

import static java.util.stream.IntStream.range;

public class MemoizerPatternLoader5 {

    @NoArgsConstructor
    public static class Memoizer<V, R> {
        private Function<? super V, ? extends R> function;
        private HashMap<V, R> map = new HashMap<>();

        public final void init(final Function<? super V, ? extends R> function) {
            this.function = Objects.requireNonNull(function);
        }

        public final R memoize(final V value) {
            return this.map.computeIfAbsent(value, this.function);
        }
    }

    public static void main(final String[] args) {
        final Memoizer<Integer, Integer> memoizer = new Memoizer<>();
        memoizer.init(n -> {
            if (n < 2) {
                return 1;
            }
            return memoizer.memoize(n - 1) + memoizer.memoize(n - 2);
        });

        range(0, 20).map(memoizer::memoize).forEach(System.out::println);
    }
}
