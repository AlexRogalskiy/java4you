package com.sensiblemetrics.api.alpenidos.core.facade2.impl;

import lombok.extern.slf4j.Slf4j;

/**
 * DwarvenGoldDigger is one of the goldmine subsystems.
 */
@Slf4j
public class DwarvenGoldDigger extends DwarvenMineWorker {

    @Override
    public void work() {
        log.info("{} digs for gold.", name());
    }

    @Override
    public String name() {
        return "Dwarf gold digger";
    }
}
