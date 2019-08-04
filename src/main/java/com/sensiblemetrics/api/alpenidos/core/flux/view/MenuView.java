package com.sensiblemetrics.api.alpenidos.core.flux.view;

import com.sensiblemetrics.api.alpenidos.core.flux.action.enums.MenuItem;
import com.sensiblemetrics.api.alpenidos.core.flux.dispatcher.Dispatcher;
import com.sensiblemetrics.api.alpenidos.core.flux.store.MenuStore;
import com.sensiblemetrics.api.alpenidos.core.flux.store.Store;
import com.sensiblemetrics.api.alpenidos.core.flux.view.iface.View;
import lombok.extern.slf4j.Slf4j;

/**
 * MenuView is a concrete view.
 */
@Slf4j
public class MenuView implements View {
    private MenuItem selected = MenuItem.HOME;

    @Override
    public void storeChanged(final Store store) {
        final MenuStore menuStore = (MenuStore) store;
        this.selected = menuStore.getSelected();
        this.render();
    }

    @Override
    public void render() {
        for (final MenuItem item : MenuItem.values()) {
            if (this.selected.equals(item)) {
                log.info("* {}", item);
            } else {
                log.info(item.toString());
            }
        }
    }

    public void itemClicked(final MenuItem item) {
        Dispatcher.getInstance().menuItemSelected(item);
    }
}
