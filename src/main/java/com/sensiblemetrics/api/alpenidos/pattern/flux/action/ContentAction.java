package com.sensiblemetrics.api.alpenidos.pattern.flux.action;

import com.sensiblemetrics.api.alpenidos.pattern.flux.action.enums.ActionType;
import com.sensiblemetrics.api.alpenidos.pattern.flux.action.enums.Content;
import lombok.Getter;

/**
 * ContentAction is a concrete action.
 */
@Getter
public class ContentAction extends Action {
    private final Content content;

    public ContentAction(final Content content) {
        super(ActionType.CONTENT_CHANGED);
        this.content = content;
    }
}
