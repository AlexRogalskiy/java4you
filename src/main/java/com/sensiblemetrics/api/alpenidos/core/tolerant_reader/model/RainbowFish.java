package com.sensiblemetrics.api.alpenidos.core.tolerant_reader.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * RainbowFish is the initial schema
 */
@Getter
@AllArgsConstructor
public class RainbowFish implements Serializable {

    private static final long serialVersionUID = -7944409492995082826L;

    private final String name;
    private final int age;
    private final int lengthMeters;
    private final int weightTons;
}
