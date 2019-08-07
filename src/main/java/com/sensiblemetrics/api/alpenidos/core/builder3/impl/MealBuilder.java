package com.sensiblemetrics.api.alpenidos.core.builder3.impl;

import com.sensiblemetrics.api.alpenidos.core.builder3.model.Meal;

public abstract class MealBuilder {

    protected Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal() {
        return this.meal;
    }
}
