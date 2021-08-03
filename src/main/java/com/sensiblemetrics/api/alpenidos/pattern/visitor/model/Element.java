package com.sensiblemetrics.api.alpenidos.pattern.visitor.model;

import com.sensiblemetrics.api.alpenidos.pattern.visitor.iface.Visitor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Element {

    public final String uuid;

    public abstract void accept(final Visitor v);
}
