package com.sensiblemetrics.api.alpenidos.pattern.property.impl;

import com.sensiblemetrics.api.alpenidos.pattern.property.enums.Stats;
import com.sensiblemetrics.api.alpenidos.pattern.property.iface.Prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents Character in game and his abilities (base stats).
 */
public class Character implements Prototype {
    private final Map<Stats, Integer> properties = new HashMap<>();

    /**
     * Enumeration of Character types
     */
    public enum Type {
        WARRIOR,
        MAGE,
        ROGUE
    }

    private final Prototype prototype;
    private String name;
    private Type type;

    /**
     * Constructor
     */
    public Character() {
        this.prototype = new Prototype() { // Null-value object
            @Override
            public Integer get(final Stats stat) {
                return null;
            }

            @Override
            public boolean has(final Stats stat) {
                return false;
            }

            @Override
            public void set(final Stats stat, final Integer val) {
            }

            @Override
            public void remove(final Stats stat) {
            }
        };
    }

    public Character(final Type type, final Prototype prototype) {
        this.type = type;
        this.prototype = prototype;
    }

    /**
     * Constructor
     */
    public Character(final String name, final Character prototype) {
        this.name = name;
        this.type = prototype.type;
        this.prototype = prototype;
    }

    public String name() {
        return this.name;
    }

    public Type type() {
        return this.type;
    }

    @Override
    public Integer get(final Stats stat) {
        final boolean containsValue = this.properties.containsKey(stat);
        if (containsValue) {
            return properties.get(stat);
        }
        return prototype.get(stat);
    }

    @Override
    public boolean has(final Stats stat) {
        return this.get(stat) != null;
    }

    @Override
    public void set(final Stats stat, final Integer val) {
        this.properties.put(stat, val);
    }

    @Override
    public void remove(final Stats stat) {
        this.properties.put(stat, null);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        if (this.name != null) {
            builder.append("Player: ").append(name).append('\n');
        }
        if (this.type != null) {
            builder.append("Character type: ").append(type.name()).append('\n');
        }
        builder.append("Stats:\n");
        for (final Stats stat : Stats.values()) {
            Integer value = this.get(stat);
            if (value == null) {
                continue;
            }
            builder.append(" - ").append(stat.name()).append(':').append(value).append('\n');
        }
        return builder.toString();
    }
}
