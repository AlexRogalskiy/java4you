package com.sensiblemetrics.api.alpenidos.pattern.abstract_factory3.factory;

import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory3.button.Button;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory3.checkbox.Checkbox;

/**
 * EN: Abstract factory knows about all (abstract) product types.
 * <p>
 * RU: Абстрактная фабрика знает обо всех (абстрактных) типах продуктов.
 */
public interface GUIFactory {

    Button createButton();

    Checkbox createCheckbox();
}
