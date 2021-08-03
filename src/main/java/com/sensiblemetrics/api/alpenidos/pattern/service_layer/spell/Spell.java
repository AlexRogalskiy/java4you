package com.sensiblemetrics.api.alpenidos.pattern.service_layer.spell;

import com.sensiblemetrics.api.alpenidos.pattern.service_layer.common.BaseEntity;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.spellbook.Spellbook;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Spell entity.
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
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
