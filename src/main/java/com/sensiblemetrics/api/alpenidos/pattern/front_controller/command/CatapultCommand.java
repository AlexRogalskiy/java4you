package com.sensiblemetrics.api.alpenidos.pattern.front_controller.command;

import com.sensiblemetrics.api.alpenidos.pattern.front_controller.view.CatapultView;

/**
 * Command for catapults.
 */
public class CatapultCommand implements Command {

    @Override
    public void process() {
        new CatapultView().display();
    }
}
