package com.sensiblemetrics.api.alpenidos.core.lock_object;

import java.util.ArrayList;
import java.util.List;

/**
 * Based on: "Patterns in Java", Mark Grand.
 */
public class GameCharacter extends AbstractGameObject {
    private final List<AbstractWeapons> myWeapons = new ArrayList<>();

    public void dropAllWeapons() {
        synchronized (this.getLockObject()) {
            this.myWeapons.forEach(w -> w.setGlowing(true));
        }
    }
}
