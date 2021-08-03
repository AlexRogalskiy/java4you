package com.sensiblemetrics.api.alpenidos.pattern.fluent_interface;

import com.sensiblemetrics.api.alpenidos.pattern.fluent_interface.iface.FluentIterable;
import com.sensiblemetrics.api.alpenidos.pattern.fluent_interface.impl.LazyFluentIterable;
import com.sensiblemetrics.api.alpenidos.pattern.fluent_interface.impl.SimpleFluentIterable;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.String.valueOf;

/**
 * The Fluent Interface pattern is useful when you want to provide an easy readable, flowing API.
 * Those interfaces tend to mimic domain specific languages, so they can nearly be read as human
 * languages.
 * <p>
 * In this example two implementations of a {@link FluentIterable} interface are given. The
 * {@link SimpleFluentIterable} evaluates eagerly and would be too costly for real world
 * applications. The {@link LazyFluentIterable} is evaluated on termination. Their usage is
 * demonstrated with a simple number list that is filtered, transformed and collected. The result is
 * printed afterwards.
 */
@Slf4j
public class FluentInterfacePatternLoader {

    /**
     * Program entry point
     */
    public static void main(final String[] args) {
        final List<Integer> integerList = new ArrayList<>();
        integerList.addAll(Arrays.asList(1, -61, 14, -22, 18, -87, 6, 64, -82, 26, -98, 97, 45, 23, 2, -68, 45));

        prettyPrint("The initial list contains: ", integerList);

        final List<Integer> firstFiveNegatives = SimpleFluentIterable.fromCopyOf(integerList).filter(negatives()).first(3).asList();
        prettyPrint("The first three negative values are: ", firstFiveNegatives);

        final List<Integer> lastTwoPositives = SimpleFluentIterable.fromCopyOf(integerList).filter(positives()).last(2).asList();
        prettyPrint("The last two positive values are: ", lastTwoPositives);

        SimpleFluentIterable
            .fromCopyOf(integerList)
            .filter(number -> number % 2 == 0)
            .first()
            .ifPresent(evenNumber -> log.info("The first even number is: {}", evenNumber));

        final List<String> transformedList = SimpleFluentIterable.fromCopyOf(integerList).filter(negatives()).map(transformToString()).asList();
        prettyPrint("A string-mapped list of negative numbers contains: ", transformedList);

        final List<String> lastTwoOfFirstFourStringMapped = LazyFluentIterable
            .from(integerList)
            .filter(positives())
            .first(4)
            .last(2)
            .map(number -> "String[" + valueOf(number) + "]")
            .asList();
        prettyPrint("The lazy list contains the last two of the first four positive numbers mapped to Strings: ", lastTwoOfFirstFourStringMapped);

        LazyFluentIterable
            .from(integerList)
            .filter(negatives())
            .first(2)
            .last()
            .ifPresent(lastOfFirstTwo -> log.info("The last of the first two negatives is: {}", lastOfFirstTwo));
    }

    private static Function<Integer, String> transformToString() {
        return integer -> "String[" + integer + "]";
    }

    private static Predicate<? super Integer> negatives() {
        return integer -> integer < 0;
    }

    private static Predicate<? super Integer> positives() {
        return integer -> integer > 0;
    }

    private static <E> void prettyPrint(final String prefix, final Iterable<E> iterable) {
        prettyPrint(", ", prefix, iterable);
    }

    private static <E> void prettyPrint(final String delimiter, final String prefix, final Iterable<E> iterable) {
        final StringJoiner joiner = new StringJoiner(delimiter, prefix, ".");
        final Iterator<E> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            joiner.add(iterator.next().toString());
        }
        log.info(joiner.toString());
    }
}
