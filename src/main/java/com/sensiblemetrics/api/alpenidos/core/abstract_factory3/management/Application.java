package com.sensiblemetrics.api.alpenidos.core.abstract_factory3.management;

import com.sensiblemetrics.api.alpenidos.core.abstract_factory3.button.Button;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory3.checkbox.Checkbox;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory3.factory.GUIFactory;

/**
 * EN: Factory users don't care which concrete factory they use since they work with factories and products through abstract interfaces.
 * <p>
 * RU: Код, использующий фабрику, не волнует с какой конкретно фабрикой он работает. Все получатели продуктов работают с продуктами через абстрактный
 * интерфейс.
 */
public class Application {

    private final Button button;
    private final Checkbox checkbox;

    public Application(final GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void paint() {
        this.button.paint();
        this.checkbox.paint();
    }
}
