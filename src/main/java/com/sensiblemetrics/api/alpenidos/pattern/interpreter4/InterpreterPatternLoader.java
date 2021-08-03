package com.sensiblemetrics.api.alpenidos.pattern.interpreter4;

import com.sensiblemetrics.api.alpenidos.pattern.interpreter4.factory.Calculate;

import java.util.HashMap;
import java.util.Map;

public class InterpreterPatternLoader {

    public static void main(final String[] args) {
        final Map<String, Integer> map = new HashMap<>();
        map.put("a", 30);
        map.put("b", 40);
        map.put("c", 50);
        System.out.println(new Calculate(map).calculate());
    }
}
