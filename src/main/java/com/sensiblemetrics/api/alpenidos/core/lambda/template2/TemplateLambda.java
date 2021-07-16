package com.sensiblemetrics.api.alpenidos.core.lambda.template2;

import java.util.function.Function;

public class TemplateLambda {

    public static <E> E withResource(Function<Resource, E> f) {
        try (var resource = new Resource()) {
            return f.apply(resource);
        }
    }
}
