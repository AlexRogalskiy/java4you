package com.sensiblemetrics.api.alpenidos.core.service_layer.spell;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.sensiblemetrics.api.alpenidos.core.service_layer.common.BaseEntity;
import com.sensiblemetrics.api.alpenidos.core.service_layer.spellbook.Spellbook;

import javax.persistence.*;

/**
 * Spell entity.
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "SPELL")
public class Spell extends BaseEntity {

    private String name;

    @Id
    @GeneratedValue
    @Column(name = "SPELL_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SPELLBOOK_ID_FK", referencedColumnName = "SPELLBOOK_ID")
    private Spellbook spellbook;

    public Spell(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
