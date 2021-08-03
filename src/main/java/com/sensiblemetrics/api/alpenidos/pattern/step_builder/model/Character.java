package com.sensiblemetrics.api.alpenidos.pattern.step_builder.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * The class with many parameters.
 */
@Data
@EqualsAndHashCode
@ToString
public class Character {
    private String name;
    private String fighterClass;
    private String wizardClass;
    private String weapon;
    private String spell;
    private List<String> abilities;

    public Character(final String name) {
        this.name = name;
    }
}
