package com.sensiblemetrics.api.alpenidos.pattern.decorator6;

/**
 * @author Alexander Pashinskiy
 * @version 1.0
 * @since 5/12/2015
 */
public class SimpleCharacterCounter implements CharacterCounter {

    @Override
    public int count(final String string) {
        return string.length();
    }
}
