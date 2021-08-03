package com.sensiblemetrics.api.alpenidos.pattern.tolerant_reader.model;

import lombok.Getter;

/**
 * RainbowFishV2 is the evolved schema
 */
@Getter
public class RainbowFishV2 extends RainbowFish {

    private static final long serialVersionUID = -5027690086683870294L;

    private boolean sleeping;
    private boolean hungry;
    private boolean angry;

    public RainbowFishV2(final String name, final int age, final int lengthMeters, final int weightTons) {
        super(name, age, lengthMeters, weightTons);
    }

    /**
     * Constructor
     */
    public RainbowFishV2(final String name, final int age, final int lengthMeters, final int weightTons, final boolean sleeping, final boolean hungry, final boolean angry) {
        this(name, age, lengthMeters, weightTons);
        this.sleeping = sleeping;
        this.hungry = hungry;
        this.angry = angry;
    }
}
