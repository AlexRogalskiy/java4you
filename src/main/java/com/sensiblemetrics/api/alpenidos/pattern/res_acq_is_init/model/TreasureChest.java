package com.sensiblemetrics.api.alpenidos.pattern.res_acq_is_init.model;

import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;

/**
 * TreasureChest resource
 */
@Slf4j
public class TreasureChest implements Closeable {

    public TreasureChest() {
        log.info("Treasure chest opens.");
    }

    @Override
    public void close() {
        log.info("Treasure chest closes.");
    }
}
