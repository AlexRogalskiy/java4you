package com.sensiblemetrics.api.alpenidos.core.visitor.model;

import com.sensiblemetrics.api.alpenidos.core.visitor.iface.Visitor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Document extends Element {
    private final List<Element> elements = new ArrayList<>();

    public Document(final String uuid) {
        super(uuid);
    }

    @Override
    public void accept(final Visitor v) {
        this.elements.forEach(e -> e.accept(v));
    }
}
