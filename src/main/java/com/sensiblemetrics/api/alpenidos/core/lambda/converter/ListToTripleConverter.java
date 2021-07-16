package com.sensiblemetrics.api.alpenidos.core.lambda.converter;

import java.util.List;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

/**
 * Created by mtumilowicz on 2018-11-24.
 */
public final class ListToTripleConverter {

    public static <T> Triple<T, T, T> convert(List<T> list) {
        List<T> listOrEmpty = List.copyOf(list);

        Triple<T, T, T> triple;

        switch (listOrEmpty.size()) {
            case 0: {
                triple = ImmutableTriple.nullTriple();
                break;
            }
            case 1: {
                triple = ImmutableTriple.of(listOrEmpty.get(0), null, null);
                break;
            }
            case 2: {
                triple = ImmutableTriple.of(listOrEmpty.get(0), listOrEmpty.get(1), null);
                break;
            }
            default: {
                triple = ImmutableTriple.of(listOrEmpty.get(0), listOrEmpty.get(1), listOrEmpty.get(2));
                break;
            }
        }

        return triple;
    }
}
