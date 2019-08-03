package com.sensiblemetrics.api.alpenidos.core.collection_pipeline;

import com.sensiblemetrics.api.alpenidos.core.collection_pipeline.enums.Category;
import com.sensiblemetrics.api.alpenidos.core.collection_pipeline.factory.CarFactory;
import com.sensiblemetrics.api.alpenidos.core.collection_pipeline.impl.FunctionalProgramming;
import com.sensiblemetrics.api.alpenidos.core.collection_pipeline.impl.ImperativeProgramming;
import com.sensiblemetrics.api.alpenidos.core.collection_pipeline.model.Car;
import com.sensiblemetrics.api.alpenidos.core.collection_pipeline.model.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * In imperative-style programming, it is common to use for and while loops for
 * most kinds of data processing. Function composition is a simple technique
 * that lets you sequence modular functions to create more complex operations.
 * When you run data through the sequence, you have a collection pipeline.
 * Together, the Function Composition and Collection Pipeline patterns enable
 * you to create sophisticated programs where data flow from upstream to
 * downstream and is passed through a series of transformations.
 */
@Slf4j
public class CollectionPipelinePatternLoader {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final List<Car> cars = CarFactory.createCars();

        final List<String> modelsImperative = ImperativeProgramming.getModelsAfter2000(cars);
        log.info(modelsImperative.toString());

        final List<String> modelsFunctional = FunctionalProgramming.getModelsAfter2000(cars);
        log.info(modelsFunctional.toString());

        final Map<Category, List<Car>> groupingByCategoryImperative = ImperativeProgramming.getGroupingOfCarsByCategory(cars);
        log.info(groupingByCategoryImperative.toString());

        final Map<Category, List<Car>> groupingByCategoryFunctional = FunctionalProgramming.getGroupingOfCarsByCategory(cars);
        log.info(groupingByCategoryFunctional.toString());

        final Person john = new Person(cars);

        final List<Car> sedansOwnedImperative = ImperativeProgramming.getSedanCarsOwnedSortedByDate(Arrays.asList(john));
        log.info(sedansOwnedImperative.toString());

        final List<Car> sedansOwnedFunctional = FunctionalProgramming.getSedanCarsOwnedSortedByDate(Arrays.asList(john));
        log.info(sedansOwnedFunctional.toString());
    }
}
