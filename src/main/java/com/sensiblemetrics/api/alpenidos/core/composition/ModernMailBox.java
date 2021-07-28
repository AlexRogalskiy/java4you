package com.sensiblemetrics.api.alpenidos.core.composition;

import java.util.function.Predicate;

/**
 * @author Alexander Pashinskiy
 * @version 1.0
 * @since 5/12/2015
 */
@FunctionalInterface
public interface ModernMailBox {

    void store(final String email);

    default ModernMailBox filterMailBox(final Predicate<String> mailFilter) {
        return email -> {
            if (mailFilter.test(email)) {
                this.store(email);
            }
        };
    }
}
