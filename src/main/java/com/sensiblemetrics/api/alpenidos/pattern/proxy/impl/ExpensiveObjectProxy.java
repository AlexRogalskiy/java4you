package com.sensiblemetrics.api.alpenidos.pattern.proxy.impl;

import com.sensiblemetrics.api.alpenidos.pattern.proxy.iface.ExpensiveObject;

import java.util.Objects;

public class ExpensiveObjectProxy implements ExpensiveObject {
    private static ExpensiveObject object;

    @Override
    public void process() {
        if(Objects.isNull(object)) {
            object = new ExpensiveObjectImpl();
        }
        object.process();
    }
}
