package com.sensiblemetrics.api.alpenidos.pattern.mediator4.components;

import com.sensiblemetrics.api.alpenidos.pattern.mediator4.management.Mediator;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 * EN: Concrete components don't talk with each other. They have only one communication channel–sending requests to the mediator.
 * <p>
 * RU: Конкретные компоненты никак не связаны между собой. У них есть только один канал общения – через отправку уведомлений посреднику.
 */
public class Title extends JTextField implements Component {

    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        mediator.markNote();
    }

    @Override
    public String getName() {
        return "Title";
    }
}
