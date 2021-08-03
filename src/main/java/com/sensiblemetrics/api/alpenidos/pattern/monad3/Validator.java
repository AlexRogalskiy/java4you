package com.sensiblemetrics.api.alpenidos.pattern.monad3;

/**
 * @author Alexander Pashinskiy
 * @version 1.0
 * @since 5/12/2015
 */
public class Validator {

    public static Validation<User> validateName(User user) {
        if (user.name == null) {
            return Validation.failure(user, "Name is null");
        }
        if (user.name.isEmpty()) {
            return Validation.failure(user, "Name is empty");
        }
        return Validation.success(user);
    }

    public static Validation<User> validateAge(User user) {
        if (user.age < 18 || user.age > 100) {
            return Validation.failure(user, "Age isn't between 18 and 100");
        }
        return Validation.success(user);
    }
}
