package com.sensiblemetrics.api.alpenidos.pattern.feature_toggle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Used to demonstrate the purpose of the feature toggle. This class actually has nothing to do with the pattern.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;

    /**
     * {@inheritDoc}
     *
     * @return The {@link String} representation of the User, in this case just return the name of the user.
     */
    @Override
    public String toString() {
        return this.name;
    }
}
