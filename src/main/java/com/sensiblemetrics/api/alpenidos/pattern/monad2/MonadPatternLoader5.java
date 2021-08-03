package com.sensiblemetrics.api.alpenidos.pattern.monad2;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.function.Predicate;

public class MonadPatternLoader5 {

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

        public Validator<T> validate(final Predicate<? super T> validation, final String message) {
            if (!validation.test(this.t)) {
                return new Validator<>(this.t, new IllegalStateException(message));
            }
            return this;
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
            .validate(u -> u.getName() != null, "name is null")
            .validate(u -> !u.getName().isEmpty(), "name is empty")
            .validate(u -> u.getAge() > 0 && u.getAge() < 150, "age is between 0 and 150")
            .get();
    }
}
