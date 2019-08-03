package com.sensiblemetrics.api.alpenidos.core.collection_pipeline.impl;

import com.sensiblemetrics.api.alpenidos.core.collection_pipeline.enums.Category;
import com.sensiblemetrics.api.alpenidos.core.collection_pipeline.model.Car;
import com.sensiblemetrics.api.alpenidos.core.collection_pipeline.model.Person;
import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Imperative-style programming to iterate over the list and get the names of
 * cars made later than the year 2000. We then sort the models in ascending
 * order by year.
 *
 * <p>As you can see, there's a lot of looping in this code. First, the
 * getModelsAfter2000UsingFor method takes a list of cars as its parameter. It
 * extracts or filters out cars made after the year 2000, putting them into a
 * new list named carsSortedByYear. Next, it sorts that list in ascending order
 * by year-of-make. Finally, it loops through the list carsSortedByYear to get
 * the model names and returns them in a list.
 *
 * <p>This short example demonstrates what I call the effect of statements. While
 * functions and methods in general can be used as expressions, the {@link Collections}
 * sort method doesn't return a result. Because it is used as a statement, it
 * mutates the list given as argument. Both of the for loops also mutate lists
 * as they iterate. Being statements, that's just how these elements work. As a
 * result, the code contains unnecessary garbage variables
 */
@UtilityClass
public class ImperativeProgramming {

    /**
     * Method to return the car models built after year 2000 using for loops.
     *
     * @param cars {@link List} of {@link Car} to iterate over
     * @return {@link List} of {@link String} of car models built after year 2000
     */
    public static List<String> getModelsAfter2000(final List<Car> cars) {
        final List<Car> carsSortedByYear = Optional.ofNullable(cars)
            .orElse(Collections.emptyList())
            .stream()
            .filter(c -> c.getYear() > 2000)
            .collect(Collectors.toList());

        Collections.sort(carsSortedByYear, Comparator.comparingInt(Car::getYear));
        return carsSortedByYear.stream().map(Car::getModel).collect(Collectors.toList());
    }

    /**
     * Method to group cars by category using for loops
     *
     * @param cars {@link List} of {@link Car} to be used for grouping
     * @return {@link Map} with category as key and cars belonging to that category as value
     */
    public static Map<Category, List<Car>> getGroupingOfCarsByCategory(final List<Car> cars) {
        return Optional.ofNullable(cars)
            .orElse(Collections.emptyList())
            .stream()
            .collect(Collectors.groupingBy(Car::getCategory));
    }

    /**
     * Method to get all Sedan cars belonging to a group of persons sorted by year of manufacture using for loops
     *
     * @param persons {@link List} of {@link Person} to be used
     * @return {@link List} of {@link Car} to belonging to the group
     */
    public static List<Car> getSedanCarsOwnedSortedByDate(final List<Person> persons) {
        final List<Car> sedanCars = Optional.ofNullable(persons)
            .orElse(Collections.emptyList())
            .stream()
            .map(Person::getCars)
            .flatMap(List::stream)
            .filter(c -> Category.SEDAN.equals(c.getCategory()))
            .collect(Collectors.toList());

        sedanCars.sort(Comparator.comparingInt(Car::getYear));
        return sedanCars;
    }
}
