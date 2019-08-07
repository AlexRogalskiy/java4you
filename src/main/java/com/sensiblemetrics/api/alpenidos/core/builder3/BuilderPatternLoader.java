package com.sensiblemetrics.api.alpenidos.core.builder3;

import com.sensiblemetrics.api.alpenidos.core.builder3.factory.KFCWaiter;
import com.sensiblemetrics.api.alpenidos.core.builder3.impl.MealBuilder;
import com.sensiblemetrics.api.alpenidos.core.builder3.impl.SubMealBuilderA;
import com.sensiblemetrics.api.alpenidos.core.builder3.impl.SubMealBuilderB;
import com.sensiblemetrics.api.alpenidos.core.builder3.model.Meal;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuilderPatternLoader {

    public static void main(final String args[]) {
        final MealBuilder mbA = new SubMealBuilderA();
        final MealBuilder mbB = new SubMealBuilderB();

        final KFCWaiter waiter = new KFCWaiter();
        waiter.setMealBuilder(mbA);

        // construct meal B
        Meal meal = waiter.construct();

        // log meal
        log.info(meal.getFood());
        log.info(meal.getDrink());

        waiter.setMealBuilder(mbB);

        // construct meal A
        meal = waiter.construct();

        // log meal
        log.info(meal.getFood());
        log.info(meal.getDrink());
    }
}
