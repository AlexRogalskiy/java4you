package com.sensiblemetrics.api.alpenidos.core.specification;

import com.sensiblemetrics.api.alpenidos.core.specification.model.iface.Creature;
import com.sensiblemetrics.api.alpenidos.core.specification.model.impl.*;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Color;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Movement;
import com.sensiblemetrics.api.alpenidos.core.specification.selector.ColorSelector;
import com.sensiblemetrics.api.alpenidos.core.specification.selector.MovementSelector;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * The central idea of the Specification pattern is to separate the statement of how to match a
 * candidate, from the candidate object that it is matched against. As well as its usefulness in
 * selection, it is also valuable for validation and for building to order.
 * <p>
 * In this example we have a pool of creatures with different properties. We then have defined
 * separate selection rules (Specifications) that we apply to the collection and as output receive
 * only the creatures that match the selection criteria.
 * <p>
 * http://martinfowler.com/apsupp/spec.pdf
 */
@Slf4j
public class SpecificationPatternLoader {

    /**
     * Program entry point
     */
    public static void main(final String[] args) {
        // initialize creatures list
        final List<Creature> creatures = asList(new Goblin(), new Octopus(), new Dragon(), new Shark(), new Troll(), new KillerBee());

        // find all walking creatures
        log.info("Find all walking creatures");
        final List<Creature> walkingCreatures = creatures.stream().filter(new MovementSelector(Movement.WALKING)).collect(Collectors.toList());
        walkingCreatures.forEach(c -> log.info(c.toString()));

        // find all dark creatures
        log.info("Find all dark creatures");
        final List<Creature> darkCreatures = creatures.stream().filter(new ColorSelector(Color.DARK)).collect(Collectors.toList());
        darkCreatures.forEach(c -> log.info(c.toString()));

        // find all red and flying creatures
        log.info("Find all red and flying creatures");
        final List<Creature> redAndFlyingCreatures = creatures.stream().filter(new ColorSelector(Color.RED).and(new MovementSelector(Movement.FLYING))).collect(Collectors.toList());
        redAndFlyingCreatures.forEach(c -> log.info(c.toString()));
    }
}
