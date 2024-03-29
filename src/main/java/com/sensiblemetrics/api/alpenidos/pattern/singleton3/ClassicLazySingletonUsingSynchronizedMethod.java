package com.sensiblemetrics.api.alpenidos.pattern.singleton3;

/**
 * The pre Java 5 way of creating <em>lazy</em> singletons.
 * <p>
 * Use this approach if the Singleton has to perform resource/time expensive stuff on instantiation during startup of an application, e.g. booting of app
 * server.
 * <p>
 * NOTE: This technique works on all versions of Java. But, it is less perfomant than the Double Checked Locking approach.
 */
public class ClassicLazySingletonUsingSynchronizedMethod {

    /**
     * We lazily create the object when any Client tries to access it for the first time. Note that the member is static and final. Only 1 copy of this can
     * exist.
     */
    private static ClassicLazySingletonUsingSynchronizedMethod SINGLE_INSTANCE;

    /**
     * Lock down the constructor to prevent Client's from creating instance of this class
     */
    private ClassicLazySingletonUsingSynchronizedMethod() {
    }

    /**
     * Returns the lazily created single instance of this class.
     * <p>
     * NOTE: the entire method is synchronized. More expensive getting the mutex
     * <em>everytime</em> a Client calls this method compared to the Double Check Locking approach.
     *
     * @return single instance of this class.
     */
    public synchronized static ClassicLazySingletonUsingSynchronizedMethod getInstance() {
        if (SINGLE_INSTANCE == null) {
            SINGLE_INSTANCE = new ClassicLazySingletonUsingSynchronizedMethod();
        }

        // most of the time we just drop straight down to here and return the single instance
        return SINGLE_INSTANCE;
    }

    /**
     * The business method - we're a logger for sake of this demo.
     *
     * @param msg the message to log
     */
    public void log(String msg) {
        System.out.println("LOG: msg");
    }
}
