package com.sensiblemetrics.api.alpenidos.core.abstract_factory3.factory;

import com.sensiblemetrics.api.alpenidos.core.abstract_factory3.button.Button;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory3.button.MacOSButton;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory3.checkbox.Checkbox;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory3.checkbox.MacOSCheckbox;

/**
 * EN: Each concrete factory extends basic factory and responsible for creating products of a single variety.
 * <p>
 * RU: Каждая конкретная фабрика знает и создаёт только продукты своей вариации.
 */
public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
