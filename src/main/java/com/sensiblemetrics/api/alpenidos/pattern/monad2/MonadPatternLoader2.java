package com.sensiblemetrics.api.alpenidos.pattern.monad2;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class MonadPatternLoader2 {

    public static class Validator<T> {
        private final T t;
        private final ArrayList<Throwable> throwables = new ArrayList<>();

        private Validator(final T t) {
            this.t = t;
        }

        public T get() throws IllegalStateException {
            if (this.throwables.isEmpty()) {
                return t;
            }
            final IllegalStateException e = new IllegalStateException();
            this.throwables.forEach(e::addSuppressed);
            throw e;
        }

        public Validator<T> validate(final Predicate<? super T> validation, final String message) {
            try {
                if (!validation.test(this.t)) {
                    this.throwables.add(new IllegalStateException(message));
                }
            } catch (RuntimeException e) {
                this.throwables.add(e);
            }
            return this;
        }

        public <U> Validator<T> validate(final Function<? super T, ? extends U> projection, final Predicate<? super U> validation, String message) {
            return this.validate(projection.andThen(validation::test)::apply, message);
        }

        public static <T> Validator<T> of(final T t) {
            Objects.requireNonNull(t);
            return new Validator<>(t);
        }
    }

    @Data
    @RequiredArgsConstructor
    public static class User {
        private final String name;
        private final int age;
    }

    public static IntPredicate inBetween(final int start, final int end) {
        return value -> value > start && value < end;
    }

    public static void main(final String[] args) {
        final User user = new User("bob", 12);
        //User user = new User("", -12);
        final User validatedUser = Validator.of(user)
            .validate(User::getName, Objects::nonNull, "name is null")
            .validate(User::getName, name -> !name.isEmpty(), "name is empty")
            //.validate(User::getAge, age -> age > 0 && age < 150, "age is between 0 and 150")
            .validate(User::getAge, inBetween(0, 150)::test, "age is between 0 and 150")
            .get();
    }
}
