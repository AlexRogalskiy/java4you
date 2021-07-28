package com.sensiblemetrics.api.alpenidos.core.iterator5;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.springframework.util.Assert;

/**
 * @author Alexander Pashinskiy
 * @version 1.0
 * @since 04/12/2015
 */
@FunctionalInterface
public interface ModernBook extends Supplier<Stream<String>> {

    Stream<String> chaptersStream();

    static <T> ModernBook of(final String... t) {
        return () -> Arrays.stream(t);
    }

    static ModernBook of(final Iterable<String> iterable) {
        Assert.notNull(iterable, "Iterable must not be null!");

        return () -> StreamSupport.stream(iterable.spliterator(), false);
    }

    default ModernBook map(final Function<? super String, String> mapper) {
        Assert.notNull(mapper, "Mapping function must not be null!");

        return () -> this.chaptersStream().map(mapper);
    }

    default ModernBook flatMap(final Function<? super String, ? extends Stream<? extends String>> mapper) {
        Assert.notNull(mapper, "Mapping function must not be null!");

        return () -> this.chaptersStream().flatMap(mapper);
    }

    default ModernBook filter(Predicate<? super String> predicate) {
        Assert.notNull(predicate, "Filter predicate must not be null!");

        return () -> this.chaptersStream().filter(predicate);
    }

    default ModernBook and(final Supplier<? extends Stream<String>> stream) {
        Assert.notNull(stream, "Stream must not be null!");

        return () -> Stream.concat(this.chaptersStream(), stream.get());
    }

    @Override
    default Stream<String> get() {
        return this.chaptersStream();
    }
}
