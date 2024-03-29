package com.sensiblemetrics.api.alpenidos.pattern.fsm3.model;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class OrderIdentifier {

    private String identifier;

    public OrderIdentifier(String identifier) {
        this.identifier = requireNonNull(identifier);
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OrderIdentifier that = (OrderIdentifier) obj;
        return Objects.equals(this.identifier, that.identifier);
    }

    @Override
    public String toString() {
        return identifier;
    }

}
