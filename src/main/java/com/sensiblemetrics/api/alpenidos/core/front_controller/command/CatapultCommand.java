package com.sensiblemetrics.api.alpenidos.core.front_controller.command;

import com.sensiblemetrics.api.alpenidos.core.front_controller.view.CatapultView;

/**
 * Command for catapults.
 */
public class CatapultCommand implements Command {

    @Override
    public void process() {
        new CatapultView().display();
    }
}
