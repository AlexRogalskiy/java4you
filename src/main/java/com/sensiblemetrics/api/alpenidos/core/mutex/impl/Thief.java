package com.sensiblemetrics.api.alpenidos.core.mutex.impl;

import com.sensiblemetrics.api.alpenidos.core.mutex.impl.Jar;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Thief is a class which continually tries to acquire a jar and take a bean
 * from it. When the jar is empty the thief stops.
 */
@Slf4j
@RequiredArgsConstructor
public class Thief extends Thread {

    /**
     * The name of the thief.
     */
    private final String name;
    /**
     * The jar
     */
    private final Jar jar;

    /**
     * In the run method the thief repeatedly tries to take a bean until none
     * are left.
     */
    @Override
    public void run() {
        int beans = 0;
        while (this.jar.takeBean()) {
            beans = beans + 1;
            log.info("{} took a bean.", name);
        }
        log.info("{} took {} beans.", name, beans);
    }
}
