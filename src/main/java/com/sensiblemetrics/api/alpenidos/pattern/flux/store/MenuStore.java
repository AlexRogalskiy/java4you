package com.sensiblemetrics.api.alpenidos.pattern.flux.store;

import com.sensiblemetrics.api.alpenidos.pattern.flux.action.Action;
import com.sensiblemetrics.api.alpenidos.pattern.flux.action.MenuAction;
import com.sensiblemetrics.api.alpenidos.pattern.flux.action.enums.ActionType;
import com.sensiblemetrics.api.alpenidos.pattern.flux.action.enums.MenuItem;
import lombok.Getter;

/**
 * MenuStore is a concrete store.
 */
@Getter
public class MenuStore extends Store {
    private MenuItem selected = MenuItem.HOME;

    @Override
    public void onAction(final Action action) {
        if (action.getType().equals(ActionType.MENU_ITEM_SELECTED)) {
            final MenuAction menuAction = (MenuAction) action;
            this.selected = menuAction.getMenuItem();
            this.notifyChange();
        }
    }
}
