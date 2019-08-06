package com.sensiblemetrics.api.alpenidos.core.tolerant_reader.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * RainbowFish is the initial schema
 */
@Getter
@AllArgsConstructor
public class RainbowFish implements Serializable {

    private static final long serialVersionUID = -7944409492995082826L;

    private String name;
    private int age;
    private int lengthMeters;
    private int weightTons;
}
