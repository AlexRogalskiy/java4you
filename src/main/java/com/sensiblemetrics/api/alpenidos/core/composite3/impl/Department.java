package com.sensiblemetrics.api.alpenidos.core.composite3.impl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Department extends Organization {

    public Department(final String name) {
        super(name);
    }

    public void inform(String info) {
        log.info("{}-{}", info, getName());
    }
}
