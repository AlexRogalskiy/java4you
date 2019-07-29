package com.sensiblemetrics.api.alpenidos.core.dynamiclinkage.impl;

import com.sensiblemetrics.api.alpenidos.core.dynamiclinkage.iface.FoodProcessorEnvironmentIF;
import lombok.Data;

@Data
public abstract class AbstractFoodProcessorProgram {

    private FoodProcessorEnvironmentIF environmentIF;

    public AbstractFoodProcessorProgram(final FoodProcessorEnvironmentIF environmentIF) {
        this.environmentIF = environmentIF;
    }

    public abstract String getName();

    public abstract void start();
}
