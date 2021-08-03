package com.sensiblemetrics.api.alpenidos.pattern.dependency_injection.wizard;

import com.sensiblemetrics.api.alpenidos.pattern.dependency_injection.iface.Wizard;
import com.sensiblemetrics.api.alpenidos.pattern.dependency_injection.model.OldTobyTobacco;

/**
 * Naive Wizard implementation violating the inversion of control principle. It should depend on
 * abstraction instead.
 */
public class SimpleWizard implements Wizard {

    private OldTobyTobacco tobacco = new OldTobyTobacco();

    public void smoke() {
        this.tobacco.smoke(this);
    }
}
