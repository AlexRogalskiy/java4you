package com.sensiblemetrics.api.alpenidos.pattern.layers.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * CakeLayer entity
 */
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
public class CakeLayer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int calories;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cake cake;

    public CakeLayer(final String name, final int calories) {
        this.setName(name);
        this.setCalories(calories);
    }
}
