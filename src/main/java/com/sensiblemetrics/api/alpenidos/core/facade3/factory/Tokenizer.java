package com.sensiblemetrics.api.alpenidos.core.facade3.factory;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Tokenizer, tokenize input string into tokens.
 */
@UtilityClass
public class Tokenizer {

    public static List<String> tokenize(final String source) {
        final List<String> tokens = new ArrayList<>();
        final StringTokenizer stringTokenizer = new StringTokenizer(source);
        while (stringTokenizer.hasMoreElements()) {
            tokens.add((String) stringTokenizer.nextElement());
        }
        return tokens;
    }
}
