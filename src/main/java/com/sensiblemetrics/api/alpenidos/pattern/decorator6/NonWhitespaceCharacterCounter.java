package com.sensiblemetrics.api.alpenidos.pattern.decorator6;

/**
 * @author Alexander Pashinskiy
 * @version 1.0
 * @since 5/12/2015
 */
public class NonWhitespaceCharacterCounter implements CharacterCounter {

    private final CharacterCounter characterCounter;

    public NonWhitespaceCharacterCounter(final CharacterCounter characterCounter) {
        this.characterCounter = characterCounter;
    }

    @Override
    public int count(final String string) {
        final String stringWithoutWhitespaces = string.replaceAll(" ", "");

        return this.characterCounter.count(stringWithoutWhitespaces);
    }
}
