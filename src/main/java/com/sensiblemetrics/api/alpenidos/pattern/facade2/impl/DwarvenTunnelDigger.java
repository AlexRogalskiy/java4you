package com.sensiblemetrics.api.alpenidos.pattern.facade2.impl;

import lombok.extern.slf4j.Slf4j;

/**
 * DwarvenTunnelDigger is one of the goldmine subsystems.
 */
@Slf4j
public class DwarvenTunnelDigger extends DwarvenMineWorker {

    @Override
    public void work() {
        log.info("{} creates another promising tunnel.", name());
    }

    @Override
    public String name() {
        return "Dwarven tunnel digger";
    }
}
