package com.sensiblemetrics.api.alpenidos.pattern.flux.store;

import com.sensiblemetrics.api.alpenidos.pattern.flux.action.Action;
import com.sensiblemetrics.api.alpenidos.pattern.flux.action.ContentAction;
import com.sensiblemetrics.api.alpenidos.pattern.flux.action.enums.ActionType;
import com.sensiblemetrics.api.alpenidos.pattern.flux.action.enums.Content;
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
