package com.sensiblemetrics.api.alpenidos.pattern.flux.dispatcher;

import com.sensiblemetrics.api.alpenidos.pattern.flux.action.Action;
import com.sensiblemetrics.api.alpenidos.pattern.flux.action.ContentAction;
import com.sensiblemetrics.api.alpenidos.pattern.flux.action.MenuAction;
import com.sensiblemetrics.api.alpenidos.pattern.flux.action.enums.Content;
import com.sensiblemetrics.api.alpenidos.pattern.flux.action.enums.MenuItem;
import com.sensiblemetrics.api.alpenidos.pattern.flux.store.Store;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

/**
 * Dispatcher sends Actions to registered Stores.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Dispatcher {
    private static final Dispatcher instance = new Dispatcher();
    private final List<Store> stores = new LinkedList<>();

    public static Dispatcher getInstance() {
        return instance;
    }

    public void registerStore(final Store store) {
        this.stores.add(store);
    }

    /**
     * Menu item selected handler
     */
    public void menuItemSelected(final MenuItem menuItem) {
        this.dispatchAction(new MenuAction(menuItem));
        switch (menuItem) {
            case HOME:
            case PRODUCTS:
            default:
                this.dispatchAction(new ContentAction(Content.PRODUCTS));
                break;
            case COMPANY:
                this.dispatchAction(new ContentAction(Content.COMPANY));
                break;
        }
    }

    private void dispatchAction(final Action action) {
        this.stores.forEach(store -> store.onAction(action));
    }
}
