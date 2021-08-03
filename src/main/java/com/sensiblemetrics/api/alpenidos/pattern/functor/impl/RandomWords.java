package com.sensiblemetrics.api.alpenidos.pattern.functor.impl;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Class to generate a list of random words
 */
@Slf4j
public class RandomWords {
    public static final int MIN_LIMIT_BOUND = 0;
    public static final int MAX_LIMIT_BOUND = 235886;
    private final List<String> sourceWords;

    /**
     * Constructor
     *
     * @throws IOException If the source words file cannot be read
     */
    public RandomWords() throws IOException {
        try (final BufferedReader reader = Files.newBufferedReader(Paths.get("words"))) {
            this.sourceWords = reader.lines().collect(Collectors.toList());    // YOUR CODE HERE
            log.info("Loaded " + this.sourceWords.size() + " words");
        }
    }

    /**
     * Create a list of a given size containing random words
     *
     * @param listSize The size of the list to create
     * @return The created list
     */
    public List<String> createList(final int listSize) {
        final Random rand = new Random();
        final List<String> wordList = rand.ints(listSize, MIN_LIMIT_BOUND, MAX_LIMIT_BOUND)
            .mapToObj(this.sourceWords::get)
            .collect(Collectors.toList());
        return wordList;
    }

    /**
     * Return the list of all source words, which cannot be modified
     *
     * @return The unmodifiable list of all source words
     */
    public List<String> allWords() {
        return Collections.unmodifiableList(this.sourceWords);
    }
}
