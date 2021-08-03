package com.sensiblemetrics.api.alpenidos.pattern.composite2.model;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Word
 */
public class Word extends LetterComposite {

    /**
     * Constructor
     */
    public Word(final List<Letter> letters) {
        Optional.ofNullable(letters).orElse(Collections.emptyList()).forEach(this::add);
    }

    @Override
    protected void printThisBefore() {
        System.out.print(" ");
    }
}
