package com.sensiblemetrics.api.alpenidos.pattern.res_acq_is_init;

import com.sensiblemetrics.api.alpenidos.pattern.res_acq_is_init.model.SlidingDoor;
import com.sensiblemetrics.api.alpenidos.pattern.res_acq_is_init.model.TreasureChest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Resource Acquisition Is Initialization pattern was developed for exception safe resource management by C++ creator Bjarne Stroustrup.
 * <p>
 * In RAII resource is tied to object lifetime: resource allocation is done during object creation while resource deallocation is done during object
 * destruction.
 * <p>
 * In Java RAII is achieved with try-with-resources statement and interfaces {@link java.io.Closeable} and {@link AutoCloseable}. The try-with-resources
 * statement ensures that each resource is closed at the end of the statement. Any object that implements {@link java.lang.AutoCloseable}, which includes all
 * objects which implement {@link java.io.Closeable}, can be used as a resource.
 * <p>
 * In this example, {@link SlidingDoor} implements {@link AutoCloseable} and {@link TreasureChest} implements {@link java.io.Closeable}. Running the example, we
 * can observe that both resources are automatically closed.
 * <p>
 * http://docs.oracle.com/javase/7/docs/technotes/guides/language/try-with-resources.html
 */
public class PatternLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatternLoader.class);

    /**
     * Program entry point
     */
    public static void main(final String[] args) throws Exception {
        try (final SlidingDoor slidingDoor = new SlidingDoor()) {
            LOGGER.info("Walking in.");
        }

        try (final TreasureChest treasureChest = new TreasureChest()) {
            LOGGER.info("Looting contents.");
        }
    }
}
