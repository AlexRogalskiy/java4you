package com.sensiblemetrics.api.alpenidos.pattern.composite2.model;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Sentence
 */
public class Sentence extends LetterComposite {

    /**
     * Constructor
     */
    public Sentence(final List<Word> words) {
        Optional.ofNullable(words).orElse(Collections.emptyList()).forEach(this::add);
    }

    @Override
    protected void printThisAfter() {
        System.out.print(".");
    }
}
