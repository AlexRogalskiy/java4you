package com.sensiblemetrics.api.alpenidos.core.state.impl;

import com.sensiblemetrics.api.alpenidos.core.state.model.Mammoth;
import com.sensiblemetrics.api.alpenidos.core.state.iface.State;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Peaceful state.
 */
@Slf4j
@RequiredArgsConstructor
public class PeacefulState implements State {
    private final Mammoth mammoth;

    @Override
    public void observe() {
        log.info("{} is calm and peaceful.", this.mammoth);
    }

    @Override
    public void onEnterState() {
        log.info("{} calms down.", this.mammoth);
    }
}
