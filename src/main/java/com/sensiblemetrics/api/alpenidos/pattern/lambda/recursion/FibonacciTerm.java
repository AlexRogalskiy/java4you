package com.sensiblemetrics.api.alpenidos.pattern.lambda.recursion;

public class FibonacciTerm {

    private final int first;
    private final int second;

    public FibonacciTerm() {
        this(0, 1);
    }

    private FibonacciTerm(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public FibonacciTerm next() {
        return new FibonacciTerm(this.second, this.first + this.second);
    }

    public long get() {
        return this.second;
    }
}
