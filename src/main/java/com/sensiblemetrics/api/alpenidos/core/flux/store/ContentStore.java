package com.sensiblemetrics.api.alpenidos.core.flux.store;

import com.sensiblemetrics.api.alpenidos.core.flux.action.Action;
import com.sensiblemetrics.api.alpenidos.core.flux.action.ContentAction;
import com.sensiblemetrics.api.alpenidos.core.flux.action.enums.ActionType;
import com.sensiblemetrics.api.alpenidos.core.flux.action.enums.Content;
import lombok.Getter;

/**
 * ContentStore is a concrete store.
 */
@Getter
public class ContentStore extends Store {
    private Content content = Content.PRODUCTS;

    @Override
    public void onAction(final Action action) {
        if (action.getType().equals(ActionType.CONTENT_CHANGED)) {
            final ContentAction contentAction = (ContentAction) action;
            this.content = contentAction.getContent();
            this.notifyChange();
        }
    }
}
