package com.sensiblemetrics.api.alpenidos.core.mvc.controller;

import com.sensiblemetrics.api.alpenidos.core.mvc.model.GiantModel;
import com.sensiblemetrics.api.alpenidos.core.mvc.view.GiantView;
import com.sensiblemetrics.api.alpenidos.core.mvc.enums.Health;
import com.sensiblemetrics.api.alpenidos.core.mvc.enums.Nourishment;
import com.sensiblemetrics.api.alpenidos.core.mvc.enums.Fatigue;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * GiantController can update the giant data and redraw it using the view.
 */
@Data
@RequiredArgsConstructor
public class GiantController {
    private final GiantModel giant;
    private final GiantView view;

    public Health getHealth() {
        return this.giant.getHealth();
    }

    public void setHealth(final Health health) {
        this.giant.setHealth(health);
    }

    public Fatigue getFatigue() {
        return this.giant.getFatigue();
    }

    public void setFatigue(final Fatigue fatigue) {
        this.giant.setFatigue(fatigue);
    }

    public Nourishment getNourishment() {
        return this.giant.getNourishment();
    }

    public void setNourishment(final Nourishment nourishment) {
        this.giant.setNourishment(nourishment);
    }

    public void updateView() {
        this.view.displayGiant(this.giant);
    }
}
