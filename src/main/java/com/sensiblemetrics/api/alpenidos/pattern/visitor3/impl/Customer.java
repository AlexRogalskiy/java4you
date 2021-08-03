package com.sensiblemetrics.api.alpenidos.pattern.visitor3.impl;

import com.sensiblemetrics.api.alpenidos.pattern.visitor3.model.Apple;
import com.sensiblemetrics.api.alpenidos.pattern.visitor3.model.Book;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Customer extends Visitor {

    public Customer(final String name) {
        super(name);
    }

    public void visit(final Apple apple) {
        log.info("Apple name: " + this.name);
    }

    public void visit(final Book book) {
        log.info("Book name: " + this.name);
    }
}
