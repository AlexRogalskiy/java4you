package com.sensiblemetrics.api.alpenidos.core.object_pool2;

import com.sensiblemetrics.api.alpenidos.core.object_pool2.impl.Oliphaunt;
import com.sensiblemetrics.api.alpenidos.core.object_pool2.impl.OliphauntPool;
import com.sensiblemetrics.api.alpenidos.core.object_pool2.pool.ObjectPool;
import lombok.extern.slf4j.Slf4j;

/**
 * When it is necessary to work with a large number of objects that are particularly expensive to
 * instantiate and each object is only needed for a short period of time, the performance of an
 * entire application may be adversely affected. An object pool design pattern may be deemed
 * desirable in cases such as these.
 * <p>
 * The object pool design pattern creates a set of objects that may be reused. When a new object is
 * needed, it is requested from the pool. If a previously prepared object is available it is
 * returned immediately, avoiding the instantiation cost. If no objects are present in the pool, a
 * new item is created and returned. When the object has been used and is no longer needed, it is
 * returned to the pool, allowing it to be used again in the future without repeating the
 * computationally expensive instantiation process. It is important to note that once an object has
 * been used and returned, existing references will become invalid.
 * <p>
 * In this example we have created {@link OliphauntPool} inheriting from generic {@link ObjectPool}.
 * {@link Oliphaunt}s can be checked out from the pool and later returned to it. The pool tracks
 * created instances and their status (available, inUse).
 */
@Slf4j
public class ObjectPoolPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        final OliphauntPool pool = new OliphauntPool();
        log.info(pool.toString());

        final Oliphaunt oliphaunt1 = pool.checkOut();
        log.info("Checked out {}", oliphaunt1);
        log.info(pool.toString());

        final Oliphaunt oliphaunt2 = pool.checkOut();
        log.info("Checked out {}", oliphaunt2);

        final Oliphaunt oliphaunt3 = pool.checkOut();
        log.info("Checked out {}", oliphaunt3);
        log.info(pool.toString());

        log.info("Checking in {}", oliphaunt1);
        pool.checkIn(oliphaunt1);
        log.info("Checking in {}", oliphaunt2);
        pool.checkIn(oliphaunt2);
        log.info(pool.toString());

        final Oliphaunt oliphaunt4 = pool.checkOut();
        log.info("Checked out {}", oliphaunt4);

        final Oliphaunt oliphaunt5 = pool.checkOut();
        log.info("Checked out {}", oliphaunt5);
        log.info(pool.toString());
    }
}
