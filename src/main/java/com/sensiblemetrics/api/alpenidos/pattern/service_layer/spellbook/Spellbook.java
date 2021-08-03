package com.sensiblemetrics.api.alpenidos.pattern.service_layer.spellbook;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.common.BaseEntity;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.spell.Spell;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.wizard.Wizard;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Spellbook entity.
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Table(name = "SPELLBOOK")
public class Spellbook extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "SPELLBOOK_ID")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "spellbooks", fetch = FetchType.EAGER)
    private final Set<Wizard> wizards = new HashSet<>();

    @OneToMany(mappedBy = "spellbook", orphanRemoval = true, cascade = CascadeType.ALL)
    private final Set<Spell> spells = new HashSet<>();

    public Spellbook(final String name) {
        this.name = name;
    }

    public void addSpell(final Spell spell) {
        spell.setSpellbook(this);
        this.spells.add(spell);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
