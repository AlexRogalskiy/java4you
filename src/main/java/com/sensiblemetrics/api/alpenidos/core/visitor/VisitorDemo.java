package com.sensiblemetrics.api.alpenidos.core.visitor;

import com.sensiblemetrics.api.alpenidos.core.visitor.iface.Visitor;
import com.sensiblemetrics.api.alpenidos.core.visitor.impl.ElementVisitor;
import com.sensiblemetrics.api.alpenidos.core.visitor.model.Document;
import com.sensiblemetrics.api.alpenidos.core.visitor.model.JsonElement;
import com.sensiblemetrics.api.alpenidos.core.visitor.model.XmlElement;

import java.util.UUID;

public class VisitorDemo {

    public static void main(final String[] args) {
        final Visitor v = new ElementVisitor();

        final Document d = new Document(generateUuid());
        d.getElements().add(new JsonElement(generateUuid()));
        d.getElements().add(new JsonElement(generateUuid()));
        d.getElements().add(new XmlElement(generateUuid()));
        d.accept(v);
    }

    private static String generateUuid() {
        return UUID.randomUUID().toString();
    }
}
