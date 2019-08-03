package com.sensiblemetrics.api.alpenidos.core.dependency_injection.module;

import com.google.inject.AbstractModule;
import com.sensiblemetrics.api.alpenidos.core.dependency_injection.model.RivendellTobacco;
import com.sensiblemetrics.api.alpenidos.core.dependency_injection.model.Tobacco;

/**
 * Guice module for binding certain concrete {@link Tobacco} implementation.
 */
public class TobaccoModule extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(Tobacco.class).to(RivendellTobacco.class);
    }
}
