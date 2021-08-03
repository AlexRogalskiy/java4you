package com.sensiblemetrics.api.alpenidos.pattern.visitor.impl;

import com.sensiblemetrics.api.alpenidos.pattern.visitor.iface.Visitor;
import com.sensiblemetrics.api.alpenidos.pattern.visitor.model.JsonElement;
import com.sensiblemetrics.api.alpenidos.pattern.visitor.model.XmlElement;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ElementVisitor implements Visitor {

    @Override
    public void visit(final XmlElement xe) {
        log.info("processing xml element with uuid: " + xe.uuid);
    }

    @Override
    public void visit(final JsonElement je) {
        log.info("processing json element with uuid: " + je.uuid);
    }
}
