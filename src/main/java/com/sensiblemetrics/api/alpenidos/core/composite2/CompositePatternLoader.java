package com.sensiblemetrics.api.alpenidos.core.composite2;

import com.sensiblemetrics.api.alpenidos.core.composite2.impl.Messenger;
import com.sensiblemetrics.api.alpenidos.core.composite2.model.LetterComposite;
import lombok.extern.slf4j.Slf4j;

/**
 * The Composite pattern is a partitioning design pattern. The Composite pattern describes that a
 * group of objects is to be treated in the same way as a single instance of an object. The intent
 * of a composite is to "compose" objects into tree structures to represent part-whole hierarchies.
 * Implementing the Composite pattern lets clients treat individual objects and compositions
 * uniformly.
 * <p>
 * In this example we have sentences composed of words composed of letters. All of the objects can
 * be treated through the same interface ({@link LetterComposite}).
 */
@Slf4j
public class CompositePatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        log.info("Message from the orcs: ");
        final LetterComposite orcMessage = new Messenger().messageFromOrcs();
        orcMessage.print();

        log.info("\nMessage from the elves: ");
        final LetterComposite elfMessage = new Messenger().messageFromElves();
        elfMessage.print();
    }
}
