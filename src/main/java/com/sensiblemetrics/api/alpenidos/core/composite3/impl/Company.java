package com.sensiblemetrics.api.alpenidos.core.composite3.impl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Company extends Organization {

    public Company(String name) {
        super(name);
    }

    public void inform(final String info) {
        log.info("{}-{}", info, getName());
        this.getChildOrgs().forEach(org -> org.inform(info + "-"));
    }
}
