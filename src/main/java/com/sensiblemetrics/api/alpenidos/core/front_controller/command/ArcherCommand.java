package com.sensiblemetrics.api.alpenidos.core.front_controller.command;

import com.sensiblemetrics.api.alpenidos.core.front_controller.view.ArcherView;

/**
 * Command for archers.
 */
public class ArcherCommand implements Command {

    @Override
    public void process() {
        new ArcherView().display();
    }
}
