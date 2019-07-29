package com.sensiblemetrics.api.alpenidos.core.dynamiclinkage.impl;

import com.sensiblemetrics.api.alpenidos.core.dynamiclinkage.iface.FoodProcessorEnvironmentIF;

public class ConcreteFoodProcesorProgram extends AbstractFoodProcessorProgram {

    public ConcreteFoodProcesorProgram(FoodProcessorEnvironmentIF environmentIF) {
        super(environmentIF);
    }

    @Override
    public String getName() {
        return "test";
    }

    @Override
    public void start() {
        double weight = this.getEnvironmentIF().weight();
        if (weight > 120.0 && weight < 160.0) {
            this.getEnvironmentIF().mix(4);
        }
    }
}
