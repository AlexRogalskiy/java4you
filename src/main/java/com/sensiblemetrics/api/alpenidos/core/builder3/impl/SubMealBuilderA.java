package com.sensiblemetrics.api.alpenidos.core.builder3.impl;

public class SubMealBuilderA extends MealBuilder {

    public void buildFood() {
        this.meal.setFood(String.format("{%s}: build food", this.getClass().getSimpleName()));
    }

    public void buildDrink() {
        this.meal.setDrink(String.format("{%s}: build drink", this.getClass().getSimpleName()));
    }
}
