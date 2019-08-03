package com.sensiblemetrics.api.alpenidos.core.command2.model;

import com.sensiblemetrics.api.alpenidos.core.command2.enums.Size;
import com.sensiblemetrics.api.alpenidos.core.command2.enums.Visibility;

/**
 * Goblin is the target of the spells
 */
public class Goblin extends Target {

    public Goblin() {
        this.setSize(Size.NORMAL);
        this.setVisibility(Visibility.VISIBLE);
    }

    @Override
    public String toString() {
        return "Goblin";
    }
}
