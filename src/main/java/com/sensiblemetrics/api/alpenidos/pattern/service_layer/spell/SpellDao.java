package com.sensiblemetrics.api.alpenidos.pattern.service_layer.spell;

import com.sensiblemetrics.api.alpenidos.pattern.service_layer.common.Dao;

/**
 * SpellDao interface.
 */
public interface SpellDao extends Dao<Spell> {

    Spell findByName(final String name);
}
