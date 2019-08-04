package com.sensiblemetrics.api.alpenidos.core.flux.action;

import com.sensiblemetrics.api.alpenidos.core.flux.action.enums.ActionType;
import com.sensiblemetrics.api.alpenidos.core.flux.action.enums.MenuItem;
import lombok.Getter;

/**
 * MenuAction is a concrete action.
 */
@Getter
public class MenuAction extends Action {
    private final MenuItem menuItem;

    public MenuAction(final MenuItem menuItem) {
        super(ActionType.MENU_ITEM_SELECTED);
        this.menuItem = menuItem;
    }
}
