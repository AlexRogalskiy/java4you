package com.sensiblemetrics.api.alpenidos.pattern.bday;

import java.util.HashSet;
import java.util.stream.IntStream;
import org.apache.commons.lang3.ObjectUtils;

/**
 * Created by mtumilowicz on 2018-11-16.
 */
final class StreamDistinctElementsChecker {

    static boolean check(IntStream ints) {
        return ObjectUtils.defaultIfNull(ints, IntStream.empty())
            .allMatch(new HashSet<>()::add);
    }
}
