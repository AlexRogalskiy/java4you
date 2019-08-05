package service_layer.spellbook;

import lombok.Data;
import lombok.NoArgsConstructor;
import service_layer.common.BaseEntity;
import service_layer.spell.Spell;
import service_layer.wizard.Wizard;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Spellbook entity.
 */
@Data
@Entity
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
