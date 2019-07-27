package com.sensiblemetrics.api.alpenidos.core.interpreter.model;

import lombok.RequiredArgsConstructor;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.joinWith;

@RequiredArgsConstructor
public class Row {
    private final String name;
    private final String surname;

    @Override
    public String toString() {
        return joinWith(EMPTY, this.name, this.surname);
    }
}
