package com.sensiblemetrics.api.alpenidos.core.visitor.model;

import com.sensiblemetrics.api.alpenidos.core.visitor.iface.Visitor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Element {

    public final String uuid;

    public abstract void accept(final Visitor v);
}
