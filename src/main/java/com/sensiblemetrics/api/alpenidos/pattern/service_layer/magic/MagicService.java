package com.sensiblemetrics.api.alpenidos.pattern.service_layer.magic;

import com.sensiblemetrics.api.alpenidos.pattern.service_layer.spell.Spell;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.spellbook.Spellbook;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.wizard.Wizard;

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
