package com.sensiblemetrics.api.alpenidos.core.hexagonal.domain;

import com.google.common.base.Joiner;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;

/**
 * Value object representing lottery numbers. This lottery uses sets of 4 numbers. The numbers must be unique and
 * between 1 and 20.
 */
@EqualsAndHashCode
public class LotteryNumbers {
    private final Set<Integer> numbers;

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 20;
    public static final int NUM_NUMBERS = 4;

    /**
     * Constructor. Creates random lottery numbers.
     */
    private LotteryNumbers() {
        this.numbers = new HashSet<>();
        this.generateRandomNumbers();
    }

    /**
     * Constructor. Uses given numbers.
     */
    private LotteryNumbers(final Set<Integer> givenNumbers) {
        this.numbers = new HashSet<>();
        this.numbers.addAll(givenNumbers);
    }

    /**
     * @return random LotteryNumbers
     */
    public static LotteryNumbers createRandom() {
        return new LotteryNumbers();
    }

    /**
     * @return given LotteryNumbers
     */
    public static LotteryNumbers create(final Set<Integer> givenNumbers) {
        return new LotteryNumbers(givenNumbers);
    }

    /**
     * @return lottery numbers
     */
    public Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(this.numbers);
    }

    /**
     * @return numbers as comma separated string
     */
    public String getNumbersAsString() {
        return Joiner.on(',').join(this.numbers);
    }

    /**
     * Generates 4 unique random numbers between 1-20 into numbers set.
     */
    private void generateRandomNumbers() {
        this.numbers.clear();
        final RandomNumberGenerator generator = new RandomNumberGenerator(MIN_NUMBER, MAX_NUMBER);
        while (this.numbers.size() < NUM_NUMBERS) {
            final int num = generator.nextInt();
            this.numbers.add(num);
        }
    }

    @Override
    public String toString() {
        return "LotteryNumbers{" + "numbers=" + this.numbers + '}';
    }

    /**
     * Helper class for generating random numbers.
     */
    private static class RandomNumberGenerator {
        private PrimitiveIterator.OfInt randomIterator;

        /**
         * Initialize a new random number generator that generates random numbers in the range [min, max]
         *
         * @param min the min value (inclusive)
         * @param max the max value (inclusive)
         */
        public RandomNumberGenerator(int min, int max) {
            this.randomIterator = new Random().ints(min, max + 1).iterator();
        }

        /**
         * @return a random number in the range (min, max)
         */
        public int nextInt() {
            return this.randomIterator.nextInt();
        }
    }
}
