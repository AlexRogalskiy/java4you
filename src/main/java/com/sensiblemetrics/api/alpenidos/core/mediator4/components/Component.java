package com.sensiblemetrics.api.alpenidos.core.mediator4.components;

import com.sensiblemetrics.api.alpenidos.core.mediator4.management.Mediator;

/**
 * EN: Common component interface.
 * <p>
 * RU: Общий интерфейс компонентов.
 */
public interface Component {

    void setMediator(Mediator mediator);

    String getName();
}
