package com.sensiblemetrics.api.alpenidos.core.service_layer.spellbook;

import com.sensiblemetrics.api.alpenidos.core.service_layer.common.Dao;

/**
 * SpellbookDao interface.
 */
public interface SpellbookDao extends Dao<Spellbook> {

    Spellbook findByName(final String name);
}
