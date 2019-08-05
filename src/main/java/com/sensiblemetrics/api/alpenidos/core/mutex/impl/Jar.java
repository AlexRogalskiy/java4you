package com.sensiblemetrics.api.alpenidos.core.mutex.impl;

import com.sensiblemetrics.api.alpenidos.core.mutex.iface.Lock;

/**
 * A Jar has a resource of beans which can only be accessed by a single Thief
 * (thread) at any one time. A Mutex lock is used to prevent more than one Thief
 * taking a bean simultaneously.
 */
public class Jar {

    /**
     * The lock which must be acquired to access the beans resource.
     */
    private final Lock lock;

    /**
     * The resource within the jar.
     */
    private int beans;

    public Jar(final int beans, final Lock lock) {
        this.beans = beans;
        this.lock = lock;
    }

    /**
     * Method for a thief to take a bean.
     */
    public boolean takeBean() {
        boolean success = false;
        try {
            this.lock.acquire();
            success = this.beans > 0;
            if (success) {
                this.beans = this.beans - 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.lock.release();
        }
        return success;
    }
}
