package com.sensiblemetrics.api.alpenidos.pattern.interpreter3;

import com.sensiblemetrics.api.alpenidos.pattern.interpreter3.converter.Converter;

public class InterpreterPatternLoader {

    public static void main(final String[] args) {
        System.out.println(Converter.INSTANCE.convert("五亿三十三万三千三百三十三"));
    }
}
