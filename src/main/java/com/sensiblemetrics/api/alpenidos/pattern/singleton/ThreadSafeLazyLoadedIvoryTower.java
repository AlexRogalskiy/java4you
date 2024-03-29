package com.sensiblemetrics.api.alpenidos.pattern.singleton;

/**
 * Thread-safe Singleton class. The instance is lazily initialized and thus needs synchronization
 * mechanism.
 * <p>
 * Note: if created by reflection then a singleton will not be created but multiple options in the
 * same classloader
 */
public final class ThreadSafeLazyLoadedIvoryTower {
    private static ThreadSafeLazyLoadedIvoryTower instance;

    private ThreadSafeLazyLoadedIvoryTower() {
        if (instance == null) {
            instance = this;
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    /**
     * The instance gets created only when it is called for first time. Lazy-loading
     */
    public static synchronized ThreadSafeLazyLoadedIvoryTower getInstance() {
        if (instance == null) {
            instance = new ThreadSafeLazyLoadedIvoryTower();
        }
        return instance;
    }
}
