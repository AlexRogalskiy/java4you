package com.sensiblemetrics.api.alpenidos.core.flux.store;

import com.sensiblemetrics.api.alpenidos.core.flux.action.Action;
import com.sensiblemetrics.api.alpenidos.core.flux.view.iface.View;

import java.util.LinkedList;
import java.util.List;

/**
 * Store is a data model.
 */
public abstract class Store {
    private final List<View> views = new LinkedList<>();

    public abstract void onAction(final Action action);

    public void registerView(final View view) {
        this.views.add(view);
    }

    protected void notifyChange() {
        this.views.forEach(view -> view.storeChanged(this));
    }
}
