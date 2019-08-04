package com.sensiblemetrics.api.alpenidos.core.mvc.model;

import com.sensiblemetrics.api.alpenidos.core.mvc.enums.Health;
import com.sensiblemetrics.api.alpenidos.core.mvc.enums.Nourishment;
import com.sensiblemetrics.api.alpenidos.core.mvc.enums.Fatigue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GiantModel contains the giant data
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiantModel {
    private Health health;
    private Fatigue fatigue;
    private Nourishment nourishment;

    @Override
    public String toString() {
        return String.format("The giant looks %s, %s and %s.", this.health, this.fatigue, this.nourishment);
    }
}
