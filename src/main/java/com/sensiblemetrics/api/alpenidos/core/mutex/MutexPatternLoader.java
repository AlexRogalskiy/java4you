package com.sensiblemetrics.api.alpenidos.core.mutex;

import com.sensiblemetrics.api.alpenidos.core.mutex.impl.Jar;
import com.sensiblemetrics.api.alpenidos.core.mutex.impl.Mutex;
import com.sensiblemetrics.api.alpenidos.core.mutex.impl.Thief;

/**
 * A Mutex prevents multiple threads from accessing a resource simultaneously.
 * <p>
 * In this example we have two thieves who are taking beans from a jar.
 * Only one thief can take a bean at a time. This is ensured by a Mutex lock
 * which must be acquired in order to access the jar. Each thief attempts to
 * acquire the lock, take a bean and then release the lock. If the lock has
 * already been acquired, the thief will be prevented from continuing (blocked)
 * until the lock has been released. The thieves stop taking beans once there
 * are no beans left to take.
 */
public class MutexPatternLoader {

    /**
     * main method
     */
    public static void main(final String[] args) {
        final Mutex mutex = new Mutex();
        final Jar jar = new Jar(1000, mutex);
        final Thief peter = new Thief("Peter", jar);
        final Thief john = new Thief("John", jar);

        peter.start();
        john.start();
    }
}
