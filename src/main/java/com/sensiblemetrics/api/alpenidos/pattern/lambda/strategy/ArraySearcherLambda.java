package com.sensiblemetrics.api.alpenidos.pattern.lambda.strategy;

public class ArraySearcherLambda {

    public static boolean contains(String[] array, String element, SearchStrategy strategy) {
        return strategy.search(array, element).isPositive();
    }
}
