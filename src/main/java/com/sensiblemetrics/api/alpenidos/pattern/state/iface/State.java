package com.sensiblemetrics.api.alpenidos.pattern.state.iface;

/**
 * State interface.
 */
public interface State {

    void onEnterState();

    void observe();
}
