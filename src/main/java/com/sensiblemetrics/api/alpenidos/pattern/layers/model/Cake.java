package com.sensiblemetrics.api.alpenidos.pattern.layers.model;

import com.sensiblemetrics.api.alpenidos.pattern.layers.dao.CakeTopping;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Cake entity
 */
@Data
@EqualsAndHashCode
@ToString
@Entity
public class Cake {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    private CakeTopping topping;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<CakeLayer> layers;

    public Cake() {
        this.setLayers(new HashSet<>());
    }

    public void addLayer(final CakeLayer layer) {
        this.layers.add(layer);
    }
}
