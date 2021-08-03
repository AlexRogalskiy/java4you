package com.sensiblemetrics.api.alpenidos.pattern.memento3;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Memento stores internal state of the Originator object, protects against
 * access by objects other than the Originator.
 */
@Data
@AllArgsConstructor
public class Memento {
    private int state;
}
