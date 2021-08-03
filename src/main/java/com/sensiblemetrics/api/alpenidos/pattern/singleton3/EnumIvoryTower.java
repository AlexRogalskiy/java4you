package com.sensiblemetrics.api.alpenidos.pattern.singleton3;

/**
 * Enum Singleton class. Effective Java 2nd Edition (Joshua Bloch) p. 18
 */
public enum EnumIvoryTower {
    INSTANCE;

    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName() + "@" + hashCode();
    }
}
