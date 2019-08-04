package com.sensiblemetrics.api.alpenidos.core.layers.dao;

import com.sensiblemetrics.api.alpenidos.core.layers.model.Cake;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * CakeTopping entity
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class CakeTopping {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int calories;

    @OneToOne(cascade = CascadeType.ALL)
    private Cake cake;

    public CakeTopping(final String name, final int calories) {
        this.setName(name);
        this.setCalories(calories);
    }

    @Override
    public String toString() {
        return String.format("id=%s name=%s calories=%d", this.id, this.name, this.calories);
    }
}
