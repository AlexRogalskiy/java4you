package com.sensiblemetrics.api.alpenidos.pattern.observer3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class ObserverPatternLoader {

    public static class SumCSV {
        public static double parseAndSum(final Path path) throws IOException {
            try (final Stream<String> lines = Files.lines(path)) {
                return lines
                    .flatMap(line -> Arrays.stream(line.split(",")))
                    .mapToDouble(token -> Double.parseDouble(token))
                    .sum();
            }
        }
    }

    public static void main(final String[] args) throws IOException {
        final Path path = Paths.get("test/test.csv");
        final double value = SumCSV.parseAndSum(path);
        System.out.println(value);
    }
}
