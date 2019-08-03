package com.sensiblemetrics.api.alpenidos.core.dependency_injection;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sensiblemetrics.api.alpenidos.core.dependency_injection.model.SecondBreakfastTobacco;
import com.sensiblemetrics.api.alpenidos.core.dependency_injection.model.Tobacco;
import com.sensiblemetrics.api.alpenidos.core.dependency_injection.module.TobaccoModule;
import com.sensiblemetrics.api.alpenidos.core.dependency_injection.wizard.AdvancedSorceress;
import com.sensiblemetrics.api.alpenidos.core.dependency_injection.wizard.AdvancedWizard;
import com.sensiblemetrics.api.alpenidos.core.dependency_injection.wizard.GuiceWizard;
import com.sensiblemetrics.api.alpenidos.core.dependency_injection.wizard.SimpleWizard;

/**
 * Dependency Injection pattern deals with how objects handle their dependencies. The pattern
 * implements so called inversion of control principle. Inversion of control has two specific rules:
 * - High-level modules should not depend on low-level modules. Both should depend on abstractions.
 * - Abstractions should not depend on details. Details should depend on abstractions.
 * <p>
 * In this example we show you three different wizards. The first one ({@link SimpleWizard}) is a
 * naive implementation violating the inversion of control principle. It depends directly on a
 * concrete implementation which cannot be changed.
 * <p>
 * The second and third wizards({@link AdvancedWizard} and {@link AdvancedSorceress}) are more flexible.
 * They do not depend on any concrete implementation but abstraction. They utilizes Dependency Injection
 * pattern allowing their {@link Tobacco} dependency to be injected through constructor ({@link AdvancedWizard})
 * or setter ({@link AdvancedSorceress}). This way, handling the dependency is no longer the wizard's
 * responsibility. It is resolved outside the wizard class.
 * <p>
 * The fourth example takes the pattern a step further. It uses Guice framework for Dependency
 * Injection. {@link TobaccoModule} binds a concrete implementation to abstraction. Injector is then
 * used to create {@link GuiceWizard} object with correct dependencies.
 */
public class DependencyInjectionPatterLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        final SimpleWizard simpleWizard = new SimpleWizard();
        simpleWizard.smoke();

        final AdvancedWizard advancedWizard = new AdvancedWizard(new SecondBreakfastTobacco());
        advancedWizard.smoke();

        final AdvancedSorceress advancedSorceress = new AdvancedSorceress();
        advancedSorceress.setTobacco(new SecondBreakfastTobacco());
        advancedSorceress.smoke();

        final Injector injector = Guice.createInjector(new TobaccoModule());
        final GuiceWizard guiceWizard = injector.getInstance(GuiceWizard.class);
        guiceWizard.smoke();
    }
}
