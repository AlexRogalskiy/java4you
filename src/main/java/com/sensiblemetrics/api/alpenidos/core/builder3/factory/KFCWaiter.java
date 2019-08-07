package com.sensiblemetrics.api.alpenidos.core.builder3.factory;

import com.sensiblemetrics.api.alpenidos.core.builder3.impl.MealBuilder;
import com.sensiblemetrics.api.alpenidos.core.builder3.model.Meal;

public class KFCWaiter {
    private MealBuilder mb;

    public void setMealBuilder(final MealBuilder mb) {
        this.mb = mb;
    }

    public Meal construct() {
        this.mb.buildFood();
        this.mb.buildDrink();
        return mb.getMeal();
    }
}
