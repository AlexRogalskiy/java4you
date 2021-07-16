package com.sensiblemetrics.api.alpenidos.core.lambda.recursion;

import java.util.function.IntToLongFunction;

public class FactorialJavaTrampoline implements IntToLongFunction {

    @Override
    public long applyAsLong(int value) {
        return factorial(value, 1).invoke();
    }

    private Trampoline<Long> factorial(int n, long acc) {
        return n == 1 ? Trampoline.completed(acc) : () -> factorial(n - 1, acc * n);
    }
}
