package com.sensiblemetrics.api.alpenidos.pattern.lambda.cycle;

import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class Step7_Streams_Answer {

    static int sumOfSquaresOfPositiveEvenNumbersUpTo(int max) {
        final IntPredicate isEven = x -> x % 2 == 0;
        final IntUnaryOperator square = x -> x * x;

        return IntStream
            .rangeClosed(1, max)
            .filter(isEven)
            .map(square)
            .sum();
    }
}
