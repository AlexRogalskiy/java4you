package com.sensiblemetrics.api.alpenidos.core.composite2.model;

import lombok.RequiredArgsConstructor;

/**
 * Letter
 */
@RequiredArgsConstructor
public class Letter extends LetterComposite {
    private final char c;

    @Override
    protected void printThisBefore() {
        System.out.print(c);
    }
}
