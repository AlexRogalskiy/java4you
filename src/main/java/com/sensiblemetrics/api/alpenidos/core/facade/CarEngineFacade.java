package com.sensiblemetrics.api.alpenidos.core.facade;

import com.sensiblemetrics.api.alpenidos.core.facade.controller.AirFlowController;
import com.sensiblemetrics.api.alpenidos.core.facade.controller.CoolingController;
import com.sensiblemetrics.api.alpenidos.core.facade.model.CatalyticConverter;
import com.sensiblemetrics.api.alpenidos.core.facade.model.FuelInjector;
import com.sensiblemetrics.api.alpenidos.core.facade.model.Starter;

public class CarEngineFacade {
    private static final Integer DEFAULT_COOLING_TEMP = 90;
    private static final Integer MAX_ALLOWED_TEMP = 50;

    private final FuelInjector fuelInjector = new FuelInjector();
    private final AirFlowController airFlowController = new AirFlowController();
    private final Starter starter = new Starter();
    private final CoolingController coolingController = new CoolingController();
    private final CatalyticConverter catalyticConverter = new CatalyticConverter();

    public void startEngine() {
        this.fuelInjector.on();
        this.airFlowController.takeAir();
        this.fuelInjector.on();
        this.fuelInjector.inject();
        this.starter.start();
        this.coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
        this.coolingController.run();
        this.catalyticConverter.on();
    }

    public void stopEngine() {
        this.fuelInjector.off();
        this.catalyticConverter.off();
        this.coolingController.cool(MAX_ALLOWED_TEMP);
        this.coolingController.stop();
        this.airFlowController.off();
    }
}
