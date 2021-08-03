package com.sensiblemetrics.api.alpenidos.pattern.front_controller.command;

import com.sensiblemetrics.api.alpenidos.pattern.front_controller.view.ErrorView;

/**
 * Default command in case the mapping is not successful.
 */
public class UnknownCommand implements Command {

    @Override
    public void process() {
        new ErrorView().display();
    }
}
