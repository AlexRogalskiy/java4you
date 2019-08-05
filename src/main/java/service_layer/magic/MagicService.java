package service_layer.magic;

import service_layer.spell.Spell;
import service_layer.spellbook.Spellbook;
import service_layer.wizard.Wizard;

import java.util.List;


/**
 * Service interface.
 */
public interface MagicService {

    List<Wizard> findAllWizards();

    List<Spellbook> findAllSpellbooks();

    List<Spell> findAllSpells();

    List<Wizard> findWizardsWithSpellbook(final String name);

    List<Wizard> findWizardsWithSpell(final String name);
}
