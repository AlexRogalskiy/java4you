package com.sensiblemetrics.api.alpenidos.pattern.marker.impl;

import lombok.extern.slf4j.Slf4j;

/**
 * Class defining Thief
 */
@Slf4j
public class Thief {

    public static void steal() {
        log.info("Steal valuable items");
    }

    public static void doNothing() {
        log.info("Pretend nothing happened and just leave");
    }
}
