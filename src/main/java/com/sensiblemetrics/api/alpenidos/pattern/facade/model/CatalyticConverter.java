package com.sensiblemetrics.api.alpenidos.pattern.facade.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CatalyticConverter {

    public void on() {
        log.info("Catalytic Converter switched on!");
    }

    public void off() {
        log.info("Catalytic Converter switched off!");
    }
}
