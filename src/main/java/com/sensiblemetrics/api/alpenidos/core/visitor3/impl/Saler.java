package com.sensiblemetrics.api.alpenidos.core.visitor3.impl;

import com.sensiblemetrics.api.alpenidos.core.visitor3.model.Apple;
import com.sensiblemetrics.api.alpenidos.core.visitor3.model.Book;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Saler extends Visitor {

    public Saler(final String name) {
        super(name);
    }

    public void visit(final Apple apple) {
        log.info("Saler apple name: " + this.name);
    }

    public void visit(final Book book) {
        log.info("Saler book name: " + this.name);
    }
}
