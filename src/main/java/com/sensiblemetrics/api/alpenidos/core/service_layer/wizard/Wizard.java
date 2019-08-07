package com.sensiblemetrics.api.alpenidos.core.service_layer.wizard;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.sensiblemetrics.api.alpenidos.core.service_layer.common.BaseEntity;
import com.sensiblemetrics.api.alpenidos.core.service_layer.spellbook.Spellbook;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Wizard entity.
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "WIZARD")
public class Wizard extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "WIZARD_ID")
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Spellbook> spellbooks = new HashSet<>();

    public Wizard(final String name) {
        this.name = name;
    }

    public void addSpellbook(final Spellbook spellbook) {
        spellbook.getWizards().add(this);
        this.spellbooks.add(spellbook);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
