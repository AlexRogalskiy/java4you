package service_layer.spellbook;

import service_layer.common.Dao;

/**
 * SpellbookDao interface.
 */
public interface SpellbookDao extends Dao<Spellbook> {

    Spellbook findByName(final String name);
}
