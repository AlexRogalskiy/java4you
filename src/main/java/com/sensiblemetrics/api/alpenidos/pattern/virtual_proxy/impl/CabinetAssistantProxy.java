package com.sensiblemetrics.api.alpenidos.pattern.virtual_proxy.impl;

import com.sensiblemetrics.api.alpenidos.pattern.virtual_proxy.iface.CabinetAssistantIF;

import java.lang.reflect.Constructor;
import java.util.Objects;

public class CabinetAssistantProxy implements CabinetAssistantIF {
    private CabinetAssistantIF cabinetAssistantIF;
    private String name;

    public CabinetAssistantProxy(final String name) {
        this.name = name;
    }

    private CabinetAssistantIF getCabinetAssistantIF() {
        if (Objects.isNull(this.cabinetAssistantIF)) {
            try {
                final Class clazz = Class.forName("CabinetAssistant");
                final Class<?>[] formalArgs = new Class[]{String.class};
                final Constructor<?> constructor = clazz.getConstructor(formalArgs);
                final Object[] actuals = new Object[]{this.name};
                this.cabinetAssistantIF = (CabinetAssistantIF) constructor.newInstance(actuals);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (Objects.isNull(this.cabinetAssistantIF)) {
                throw new RuntimeException();
            }
        }
        return this.cabinetAssistantIF;
    }

    @Override
    public void operation1() {
        this.getCabinetAssistantIF().operation1();
    }

    @Override
    public void operation2() {
        this.getCabinetAssistantIF().operation2();
    }
}
