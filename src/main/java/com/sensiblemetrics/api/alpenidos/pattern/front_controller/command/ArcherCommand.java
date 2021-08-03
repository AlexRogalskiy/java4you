package com.sensiblemetrics.api.alpenidos.pattern.front_controller.command;

import com.sensiblemetrics.api.alpenidos.pattern.front_controller.view.ArcherView;

/**
 * Command for archers.
 */
public class ArcherCommand implements Command {

    @Override
    public void process() {
        new ArcherView().display();
    }
}
