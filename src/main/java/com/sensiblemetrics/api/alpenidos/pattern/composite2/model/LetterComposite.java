package com.sensiblemetrics.api.alpenidos.pattern.composite2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite interface.
 */
public abstract class LetterComposite {

    private final List<LetterComposite> children = new ArrayList<>();

    public void add(final LetterComposite letter) {
        this.children.add(letter);
    }

    public int count() {
        return this.children.size();
    }

    protected void printThisBefore() {
    }

    protected void printThisAfter() {
    }

    /**
     * Print
     */
    public void print() {
        this.printThisBefore();
        this.children.forEach(LetterComposite::print);
        this.printThisAfter();
    }
}
