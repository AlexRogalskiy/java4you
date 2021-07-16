package com.sensiblemetrics.api.alpenidos.core.lambda.recursion;

import java.util.stream.IntStream;

public class Factorial {

    static long withLoop(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    static long withStream(int n) {
        return IntStream.rangeClosed(1, n)
                .reduce(1, (result, next) -> result * next);
    }

    static long withRecur(int n) {
        if (n == 1) {
            return 1;
        }

        return n * withRecur(n - 1);
    }

    public static long withTailRecur(int n) {
        return withTailRecur(n, 1);
    }

    private static long withTailRecur(int n, long result) {
        if (n == 1) {
            return result;
        }

        return withTailRecur(n - 1, n * result);
    }
}
