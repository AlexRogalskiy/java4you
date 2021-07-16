package com.sensiblemetrics.api.alpenidos.core.lambda.strategy;

@FunctionalInterface
public interface SearchStrategy {

    Index search(String[] in, String element);
}
