package com.sensiblemetrics.api.alpenidos.pattern.flux.view;

import com.sensiblemetrics.api.alpenidos.pattern.flux.action.enums.Content;
import com.sensiblemetrics.api.alpenidos.pattern.flux.store.ContentStore;
import com.sensiblemetrics.api.alpenidos.pattern.flux.store.Store;
import com.sensiblemetrics.api.alpenidos.pattern.flux.view.iface.View;
import lombok.extern.slf4j.Slf4j;

/**
 * ContentView is a concrete view.
 */
@Slf4j
public class ContentView implements View {
    private Content content = Content.PRODUCTS;

    @Override
    public void storeChanged(final Store store) {
        final ContentStore contentStore = (ContentStore) store;
        this.content = contentStore.getContent();
        this.render();
    }

    @Override
    public void render() {
        log.info(this.content.toString());
    }
}
