package com.sensiblemetrics.api.alpenidos.core.lambda.decorator;

import java.awt.Color;
import java.util.function.Function;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * Created by mtumilowicz on 2018-11-30.
 */
@Value
@RequiredArgsConstructor
class Camera {

    @Getter(AccessLevel.NONE)
    Function<Color, Color> transformColors;

    Camera() {
        this.transformColors = Function.identity();
    }

    Camera withFilter(Function<Color, Color> transform) {
        return new Camera(transformColors.andThen(transform));
    }

    Color snap(Color color) {
        return transformColors.apply(color);
    }
}
