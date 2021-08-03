package com.sensiblemetrics.api.alpenidos.pattern.monad2;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class MonadPatternLoader4 {

    @RequiredArgsConstructor
    public static class Validator<T> {
        private final T t;
        private final IllegalStateException error;

        public T get() throws IllegalStateException {
            if (this.error == null) {
                return this.t;
            }
            throw this.error;
        }

        public Validator<T> validate(final Predicate<? super T> validation, String message) {
            if (!validation.test(t)) {
                return new Validator<>(t, new IllegalStateException(message));
            }
            return this;
        }

        public <U> Validator<T> validate(final Function<? super T, ? extends U> projection, final Predicate<? super U> validation, final String message) {
            //return validate(t -> validation.test(projection.apply(t)), message);
            return this.validate(projection.andThen(validation::test)::apply, message);
        }

        public static <T> Validator<T> of(final T t) {
            Objects.requireNonNull(t);
            return new Validator<>(t, null);
        }
    }

    @Data
    @RequiredArgsConstructor
    public static class User {
        private final String name;
        private final int age;
    }

    public static void main(final String[] args) {
        final User user = new User("bob", 12);
        //User user = new User("", -12);
        final User validatedUser = Validator.of(user)
            .validate(User::getName, Objects::nonNull, "name is null")
            .validate(User::getName, name -> !name.isEmpty(), "name is empty")
            .validate(User::getAge, age -> age > 0 && age < 150, "age is between 0 and 150")
            .get();
    }
}
