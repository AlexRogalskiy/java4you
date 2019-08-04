package com.sensiblemetrics.api.alpenidos.core.flux;

import com.sensiblemetrics.api.alpenidos.core.flux.action.enums.MenuItem;
import com.sensiblemetrics.api.alpenidos.core.flux.dispatcher.Dispatcher;
import com.sensiblemetrics.api.alpenidos.core.flux.store.ContentStore;
import com.sensiblemetrics.api.alpenidos.core.flux.store.MenuStore;
import com.sensiblemetrics.api.alpenidos.core.flux.view.ContentView;
import com.sensiblemetrics.api.alpenidos.core.flux.view.MenuView;

/**
 * Flux is the application architecture that Facebook uses for building client-side web
 * applications. Flux eschews MVC in favor of a unidirectional data flow. When a user interacts with
 * a React view, the view propagates an action through a central dispatcher, to the various stores
 * that hold the application's data and business logic, which updates all of the views that are
 * affected.
 * <p>
 * This example has two views: menu and content. They represent typical main menu and content area
 * of a web page. When menu item is clicked it triggers events through the dispatcher. The events
 * are received and handled by the stores updating their data as needed. The stores then notify the
 * views that they should rerender themselves.
 * <p>
 * http://facebook.github.io/flux/docs/overview.html
 */
public class FluxPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        // initialize and wire the system
        final MenuStore menuStore = new MenuStore();
        Dispatcher.getInstance().registerStore(menuStore);

        final ContentStore contentStore = new ContentStore();
        Dispatcher.getInstance().registerStore(contentStore);

        final MenuView menuView = new MenuView();
        menuStore.registerView(menuView);
        final ContentView contentView = new ContentView();
        contentStore.registerView(contentView);

        // render initial view
        menuView.render();
        contentView.render();

        // user clicks another menu item
        // this triggers action dispatching and eventually causes views to render with new content
        menuView.itemClicked(MenuItem.COMPANY);
    }
}
