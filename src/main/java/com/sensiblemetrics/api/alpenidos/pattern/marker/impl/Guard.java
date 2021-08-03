package com.sensiblemetrics.api.alpenidos.pattern.marker.impl;

import com.sensiblemetrics.api.alpenidos.pattern.marker.iface.Permission;
import lombok.extern.slf4j.Slf4j;

/**
 * Class defining Guard
 */
@Slf4j
public class Guard implements Permission {

    public static void enter() {
        log.info("You can enter");
    }
}
