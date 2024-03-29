package com.sensiblemetrics.api.alpenidos.pattern.lambda.cycle;

import io.vavr.collection.List;
import java.util.function.Function;

public class Step4_FlatMap_Answer {

    static List<Integer> flatMap(List<Integer> xs, Function<Integer, List<Integer>> f) {
        if (xs.isEmpty()) {
            return List.empty();
        }
        return flatMap(xs.tail(), f).prependAll(f.apply(xs.head()));
    }

    static List<Integer> generatePositivesUpTo(int max) {
        if (max <= 0) {
            return List.empty();
        }
        return generatePositivesUpTo(max - 1).append(max);
    }

    static List<Integer> filterEven(List<Integer> xs) {
        return flatMap(xs, x -> x % 2 == 0 ? List.of(x) : List.empty());
    }

    static List<Integer> square(List<Integer> xs) {
        return flatMap(xs, x -> List.of(x * x));
    }

    static int sum(List<Integer> xs) {
        if (xs.isEmpty()) {
            return 0;
        }
        return xs.head() + sum(xs.tail());
    }

    static int sumOfSquaresOfPositiveEvenNumbersUpTo(int max) {
        return sum(square(filterEven(generatePositivesUpTo(max))));
    }
}
