package com.sensiblemetrics.api.alpenidos.core.state.iface;

/**
 * State interface.
 */
public interface State {

    void onEnterState();

    void observe();
}
