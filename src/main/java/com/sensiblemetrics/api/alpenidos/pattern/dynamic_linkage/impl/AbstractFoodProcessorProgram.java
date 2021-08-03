package com.sensiblemetrics.api.alpenidos.pattern.dynamic_linkage.impl;

import com.sensiblemetrics.api.alpenidos.pattern.dynamic_linkage.iface.FoodProcessorEnvironmentIF;
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
