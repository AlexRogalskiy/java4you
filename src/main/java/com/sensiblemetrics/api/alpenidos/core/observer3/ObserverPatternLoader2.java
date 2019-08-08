package com.sensiblemetrics.api.alpenidos.core.observer3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ObserverPatternLoader2 {

    public interface Observer {
        void data(final double value);
    }

    public static class CSVParser {
        public static void parse(final Path path, final Observer observer) throws IOException {
            try (final Stream<String> lines = Files.lines(path)) {
                lines
                    .flatMap(Pattern.compile(",")::splitAsStream)
                    .mapToDouble(Double::parseDouble)
                    .forEach(observer::data);
            }
        }
    }

    public static class SumCSV {
        private double sum;

        public double parseAndSum(final Path path) throws IOException {
            CSVParser.parse(path, value -> this.sum += value);
            return this.sum;
        }
    }

    public static void main(final String[] args) throws IOException {
        final Path path = Paths.get("test/test.csv");
        final double value = new SumCSV().parseAndSum(path);
        System.out.println(value);
    }
}
