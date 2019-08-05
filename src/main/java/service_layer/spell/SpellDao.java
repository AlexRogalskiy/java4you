package service_layer.spell;

import service_layer.common.Dao;

/**
 * SpellDao interface.
 */
public interface SpellDao extends Dao<Spell> {

    Spell findByName(final String name);
}
