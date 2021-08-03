package com.sensiblemetrics.api.alpenidos.pattern.service_layer.magic;

import com.sensiblemetrics.api.alpenidos.pattern.service_layer.spell.Spell;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.spell.SpellDao;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.spellbook.Spellbook;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.spellbook.SpellbookDao;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.wizard.Wizard;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.wizard.WizardDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation.
 */
public class MagicServiceImpl implements MagicService {
    private WizardDao wizardDao;
    private SpellbookDao spellbookDao;
    private SpellDao spellDao;

    /**
     * Constructor
     */
    public MagicServiceImpl(final WizardDao wizardDao, final SpellbookDao spellbookDao, final SpellDao spellDao) {
        this.wizardDao = wizardDao;
        this.spellbookDao = spellbookDao;
        this.spellDao = spellDao;
    }

    @Override
    public List<Wizard> findAllWizards() {
        return this.wizardDao.findAll();
    }

    @Override
    public List<Spellbook> findAllSpellbooks() {
        return this.spellbookDao.findAll();
    }

    @Override
    public List<Spell> findAllSpells() {
        return this.spellDao.findAll();
    }

    @Override
    public List<Wizard> findWizardsWithSpellbook(String name) {
        final Spellbook spellbook = this.spellbookDao.findByName(name);
        return new ArrayList<>(spellbook.getWizards());
    }

    @Override
    public List<Wizard> findWizardsWithSpell(String name) {
        final Spell spell = this.spellDao.findByName(name);
        final Spellbook spellbook = spell.getSpellbook();
        return new ArrayList<>(spellbook.getWizards());
    }
}
