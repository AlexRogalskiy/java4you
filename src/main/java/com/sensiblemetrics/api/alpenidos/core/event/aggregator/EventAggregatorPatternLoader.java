package com.sensiblemetrics.api.alpenidos.core.event.aggregator;

import com.sensiblemetrics.api.alpenidos.core.event.aggregator.enums.Weekday;
import com.sensiblemetrics.api.alpenidos.core.event.aggregator.impl.*;

import java.util.Arrays;
import java.util.List;

/**
 * A system with lots of objects can lead to complexities when a client wants to subscribe to
 * events. The client has to find and register for each object individually, if each object has
 * multiple events then each event requires a separate subscription.
 * <p>
 * An Event Aggregator acts as a single source of events for many objects. It registers for all the
 * events of the many objects allowing clients to register with just the aggregator.
 * <p>
 * In the example {@link LordBaelish}, {@link LordVarys} and {@link Scout} deliver events to
 * {@link KingsHand}. {@link KingsHand}, the event aggregator, then delivers the events to
 * {@link KingJoffrey}.
 */
public class EventAggregatorPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final KingJoffrey kingJoffrey = new KingJoffrey();
        final KingsHand kingsHand = new KingsHand(kingJoffrey);

        final List<EventEmitter> emitters = Arrays.asList(
            kingsHand,
            new LordBaelish(kingsHand),
            new LordVarys(kingsHand),
            new Scout(kingsHand)
        );

        for (final Weekday day : Weekday.values()) {
            for (final EventEmitter emitter : emitters) {
                emitter.timePasses(day);
            }
        }
    }
}
