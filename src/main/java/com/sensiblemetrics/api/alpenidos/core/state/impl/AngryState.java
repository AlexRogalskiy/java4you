package com.sensiblemetrics.api.alpenidos.core.state.impl;

import com.sensiblemetrics.api.alpenidos.core.state.model.Mammoth;
import com.sensiblemetrics.api.alpenidos.core.state.iface.State;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Angry state.
 */
@Slf4j
@RequiredArgsConstructor
public class AngryState implements State {
    private final Mammoth mammoth;

    @Override
    public void observe() {
        log.info("{} is furious!", this.mammoth);
    }

    @Override
    public void onEnterState() {
        log.info("{} gets angry!", this.mammoth);
    }
}
