package com.sensiblemetrics.api.alpenidos.core.monad2;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class MonadPatternLoader {

    public static void main(final String[] args) {   // no monad
        final User user = new User("bob", 12);
        //User user = new User("", -12);
        if (user.getName() == null) {
            throw new IllegalStateException("name is null");
        }
        if (user.getName().isEmpty()) {
            throw new IllegalStateException("name is empty");
        }
        if (!(user.getAge() > 0 && user.getAge() < 150)) {
            throw new IllegalStateException("age is between 0 and 150");
        }
    }

    @Data
    @RequiredArgsConstructor
    public static class User {
        private final String name;
        private final int age;
    }
}
