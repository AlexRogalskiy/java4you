package com.sensiblemetrics.api.alpenidos.core.mediator4;

import com.sensiblemetrics.api.alpenidos.core.mediator4.components.AddButton;
import com.sensiblemetrics.api.alpenidos.core.mediator4.components.DeleteButton;
import com.sensiblemetrics.api.alpenidos.core.mediator4.components.Filter;
import com.sensiblemetrics.api.alpenidos.core.mediator4.components.List;
import com.sensiblemetrics.api.alpenidos.core.mediator4.components.SaveButton;
import com.sensiblemetrics.api.alpenidos.core.mediator4.components.TextBox;
import com.sensiblemetrics.api.alpenidos.core.mediator4.components.Title;
import com.sensiblemetrics.api.alpenidos.core.mediator4.management.Editor;
import com.sensiblemetrics.api.alpenidos.core.mediator4.management.Mediator;
import javax.swing.DefaultListModel;

/**
 * EN: Demo class. Everything comes together here.
 * <p>
 * RU: Демо-класс. Здесь всё сводится воедино.
 */
public class Demo {

    public static void main(final String[] args) {
        final Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}
