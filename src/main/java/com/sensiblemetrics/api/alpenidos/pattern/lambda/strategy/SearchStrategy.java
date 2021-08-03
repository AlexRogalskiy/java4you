package com.sensiblemetrics.api.alpenidos.pattern.lambda.strategy;

@FunctionalInterface
public interface SearchStrategy {

    Index search(String[] in, String element);
}
