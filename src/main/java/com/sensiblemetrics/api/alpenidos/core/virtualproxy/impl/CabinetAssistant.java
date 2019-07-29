package com.sensiblemetrics.api.alpenidos.core.virtualproxy.impl;

import com.sensiblemetrics.api.alpenidos.core.virtualproxy.iface.CabinetAssistantIF;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CabinetAssistant implements CabinetAssistantIF {

    private final String name;

    @Override
    public void operation1() {
    }

    @Override
    public void operation2() {
    }
}
