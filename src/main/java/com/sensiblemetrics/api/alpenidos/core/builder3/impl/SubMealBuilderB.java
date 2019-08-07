package com.sensiblemetrics.api.alpenidos.core.builder3.impl;

public class SubMealBuilderB extends MealBuilder {

    public void buildFood() {
        meal.setFood(String.format("{%s}: build food", this.getClass().getSimpleName()));
    }

    public void buildDrink() {
        meal.setDrink(String.format("{%s}: build drink", this.getClass().getSimpleName()));
    }
}
