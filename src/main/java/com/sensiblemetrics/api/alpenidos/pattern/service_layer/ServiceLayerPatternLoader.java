package com.sensiblemetrics.api.alpenidos.pattern.service_layer;

import com.sensiblemetrics.api.alpenidos.pattern.service_layer.magic.MagicService;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.magic.MagicServiceImpl;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.spell.Spell;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.spell.SpellDao;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.spell.SpellDaoImpl;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.spellbook.Spellbook;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.spellbook.SpellbookDao;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.spellbook.SpellbookDaoImpl;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.wizard.Wizard;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.wizard.WizardDao;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.wizard.WizardDaoImpl;
import lombok.extern.slf4j.Slf4j;


/**
 * Service layer defines an application's boundary with a layer of services that establishes a set
 * of available operations and coordinates the application's response in each operation.
 * <p>
 * Enterprise applications typically require different kinds of interfaces to the data they store
 * and the logic they implement: data loaders, user interfaces, integration gateways, and others.
 * Despite their different purposes, these interfaces often need common interactions with the
 * application to access and manipulate its data and invoke its business logic. The interactions may
 * be complex, involving transactions across multiple resources and the coordination of several
 * responses to an action. Encoding the logic of the interactions separately in each interface
 * causes a lot of duplication.
 * <p>
 * The example application demonstrates interactions between a client ({@link ServiceLayerPatternLoader}) and a service (
 * {@link MagicService}). The service is implemented with 3-layer architecture (entity, dao,
 * service). For persistence the example uses in-memory H2 database which is populated on each
 * application startup.
 */
@Slf4j
public class ServiceLayerPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        // populate the in-memory database
        initData();
        // query the data using the service
        queryData();
    }

    /**
     * Initialize data
     */
    private static void initData() {
        // spells
        final Spell spell1 = new Spell("Ice dart");
        final Spell spell2 = new Spell("Invisibility");
        final Spell spell3 = new Spell("Stun bolt");
        final Spell spell4 = new Spell("Confusion");
        final Spell spell5 = new Spell("Darkness");
        final Spell spell6 = new Spell("Fireball");
        final Spell spell7 = new Spell("Enchant weapon");
        final Spell spell8 = new Spell("Rock armour");
        final Spell spell9 = new Spell("Light");
        final Spell spell10 = new Spell("Bee swarm");
        final Spell spell11 = new Spell("Haste");
        final Spell spell12 = new Spell("Levitation");
        final Spell spell13 = new Spell("Magic lock");
        final Spell spell14 = new Spell("Summon hell bat");
        final Spell spell15 = new Spell("Water walking");
        final Spell spell16 = new Spell("Magic storm");
        final Spell spell17 = new Spell("Entangle");

        final SpellDao spellDao = new SpellDaoImpl();
        spellDao.persist(spell1);
        spellDao.persist(spell2);
        spellDao.persist(spell3);
        spellDao.persist(spell4);
        spellDao.persist(spell5);
        spellDao.persist(spell6);
        spellDao.persist(spell7);
        spellDao.persist(spell8);
        spellDao.persist(spell9);
        spellDao.persist(spell10);
        spellDao.persist(spell11);
        spellDao.persist(spell12);
        spellDao.persist(spell13);
        spellDao.persist(spell14);
        spellDao.persist(spell15);
        spellDao.persist(spell16);
        spellDao.persist(spell17);

        // spellbooks
        final SpellbookDao spellbookDao = new SpellbookDaoImpl();
        final Spellbook spellbook1 = new Spellbook("Book of Orgymon");
        spellbookDao.persist(spellbook1);
        spellbook1.addSpell(spell1);
        spellbook1.addSpell(spell2);
        spellbook1.addSpell(spell3);
        spellbook1.addSpell(spell4);
        spellbookDao.merge(spellbook1);

        final Spellbook spellbook2 = new Spellbook("Book of Aras");
        spellbookDao.persist(spellbook2);
        spellbook2.addSpell(spell5);
        spellbook2.addSpell(spell6);
        spellbookDao.merge(spellbook2);

        final Spellbook spellbook3 = new Spellbook("Book of Kritior");
        spellbookDao.persist(spellbook3);
        spellbook3.addSpell(spell7);
        spellbook3.addSpell(spell8);
        spellbook3.addSpell(spell9);
        spellbookDao.merge(spellbook3);

        final Spellbook spellbook4 = new Spellbook("Book of Tamaex");
        spellbookDao.persist(spellbook4);
        spellbook4.addSpell(spell10);
        spellbook4.addSpell(spell11);
        spellbook4.addSpell(spell12);
        spellbookDao.merge(spellbook4);

        final Spellbook spellbook5 = new Spellbook("Book of Idores");
        spellbookDao.persist(spellbook5);
        spellbook5.addSpell(spell13);
        spellbookDao.merge(spellbook5);

        final Spellbook spellbook6 = new Spellbook("Book of Opaen");
        spellbookDao.persist(spellbook6);
        spellbook6.addSpell(spell14);
        spellbook6.addSpell(spell15);
        spellbookDao.merge(spellbook6);

        final Spellbook spellbook7 = new Spellbook("Book of Kihione");
        spellbookDao.persist(spellbook7);
        spellbook7.addSpell(spell16);
        spellbook7.addSpell(spell17);
        spellbookDao.merge(spellbook7);

        // wizards
        final WizardDao wizardDao = new WizardDaoImpl();
        final Wizard wizard1 = new Wizard("Aderlard Boud");
        wizardDao.persist(wizard1);
        wizard1.addSpellbook(spellbookDao.findByName("Book of Orgymon"));
        wizard1.addSpellbook(spellbookDao.findByName("Book of Aras"));

        wizardDao.merge(wizard1);

        final Wizard wizard2 = new Wizard("Anaxis Bajraktari");
        wizardDao.persist(wizard2);
        wizard2.addSpellbook(spellbookDao.findByName("Book of Kritior"));
        wizard2.addSpellbook(spellbookDao.findByName("Book of Tamaex"));
        wizardDao.merge(wizard2);

        final Wizard wizard3 = new Wizard("Xuban Munoa");
        wizardDao.persist(wizard3);
        wizard3.addSpellbook(spellbookDao.findByName("Book of Idores"));
        wizard3.addSpellbook(spellbookDao.findByName("Book of Opaen"));
        wizardDao.merge(wizard3);

        final Wizard wizard4 = new Wizard("Blasius Dehooge");
        wizardDao.persist(wizard4);
        wizard4.addSpellbook(spellbookDao.findByName("Book of Kihione"));
        wizardDao.merge(wizard4);
    }

    /**
     * Query the data
     */
    private static void queryData() {
        final MagicService service = new MagicServiceImpl(
            new WizardDaoImpl(),
            new SpellbookDaoImpl(),
            new SpellDaoImpl()
        );

        log.info("Enumerating all wizards");
        service.findAllWizards().forEach(w -> log.info(w.getName()));

        log.info("Enumerating all spellbooks");
        service.findAllSpellbooks().forEach(s -> log.info(s.getName()));

        log.info("Enumerating all spells");
        service.findAllSpells().forEach(s -> log.info(s.getName()));

        log.info("Find wizards with spellbook 'Book of Idores'");
        service.findWizardsWithSpellbook("Book of Idores").forEach(w -> log.info(w.getName()));

        log.info("Find wizards with spell 'Fireball'");
        service.findWizardsWithSpell("Fireball").forEach(w -> log.info(w.getName()));
    }
}
