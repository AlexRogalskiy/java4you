package com.sensiblemetrics.api.alpenidos.pattern.lambda.cycle;

import io.vavr.collection.List;

public class Step3_Recursion_Answer {

    static List<Integer> generatePositivesUpTo(int max) {
        return max <= 0
                ? List.empty()
                : generatePositivesUpTo(max - 1).append(max);
    }

    static List<Integer> filterEven(List<Integer> xs) {
        if (xs.isEmpty()) {
            return List.empty();
        } else {
            return xs.head() % 2 == 0
                ? filterEven(xs.tail()).prepend(xs.head())
                : filterEven(xs.tail());
        }
    }

    static List<Integer> square(List<Integer> xs) {
        if (xs.isEmpty()) {
            return List.empty();
        } else {
            return square(xs.tail()).prepend(xs.head() * xs.head());
        }
    }

    static int sum(List<Integer> xs) {
        if (xs.isEmpty()) {
            return 0;
        } else {
            return xs.head() + sum(xs.tail());
        }
    }

    static int sumOfSquaresOfPositiveEvenNumbersUpTo(int max) {
        return sum(square(filterEven(generatePositivesUpTo(max))));
    }
}
