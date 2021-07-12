package com.sensiblemetrics.api.alpenidos.core.abstract_factory3.factory;

import com.sensiblemetrics.api.alpenidos.core.abstract_factory3.button.Button;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory3.button.WindowsButton;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory3.checkbox.Checkbox;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory3.checkbox.WindowsCheckbox;

/**
 * EN: Each concrete factory extends basic factory and responsible for creating products of a single variety.
 * <p>
 * RU: Каждая конкретная фабрика знает и создаёт только продукты своей вариации.
 */
public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
