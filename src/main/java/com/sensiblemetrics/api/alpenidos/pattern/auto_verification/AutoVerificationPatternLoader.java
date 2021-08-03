package com.sensiblemetrics.api.alpenidos.pattern.auto_verification;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@Slf4j
public class AutoVerificationPatternLoader {

    public static void main(final String[] args) {
        final Map<String, List<String>> map = new HashMap<>();
        final Dict<String, List<String>> dict = Dict.asDict(map, ArrayList::new);
        dict.get("foo").add("bar");
        dict.get("foo").add("baz");
        log.info("Info map: " + map);
    }

    interface Dict<K, V> {
        static <K, V> Dict<K, V> asDict(final Map<? super K, V> map, final Supplier<? extends V> factory) {
            return key -> map.computeIfAbsent(key, k -> factory.get());
        }

        V get(final K key);
    }
}
