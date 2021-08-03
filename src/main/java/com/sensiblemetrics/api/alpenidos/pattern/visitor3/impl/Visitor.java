package com.sensiblemetrics.api.alpenidos.pattern.visitor3.impl;

import com.sensiblemetrics.api.alpenidos.pattern.visitor3.model.Apple;
import com.sensiblemetrics.api.alpenidos.pattern.visitor3.model.Book;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Visitor {
    protected final String name;

    public abstract void visit(final Apple apple);

    public abstract void visit(final Book book);
}
