package com.sensiblemetrics.api.alpenidos.core.mediator4.components;

import com.sensiblemetrics.api.alpenidos.core.mediator4.management.Mediator;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 * EN: Concrete components don't talk with each other. They have only one communication channel–sending requests to the mediator.
 * <p>
 * RU: Конкретные компоненты никак не связаны между собой. У них есть только один канал общения – через отправку уведомлений посреднику.
 */
public class SaveButton extends JButton implements Component {

    private Mediator mediator;

    public SaveButton() {
        super("Save");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.saveChanges();
    }

    @Override
    public String getName() {
        return "SaveButton";
    }
}
