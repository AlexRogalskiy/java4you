package com.sensiblemetrics.api.alpenidos.core.flux.view.iface;

import com.sensiblemetrics.api.alpenidos.core.flux.store.Store;

/**
 * Views define the representation of data.
 */
public interface View {

    void storeChanged(final Store store);

    void render();
}
