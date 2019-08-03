package com.sensiblemetrics.api.alpenidos.core.dependency_injection.wizard;

import com.sensiblemetrics.api.alpenidos.core.dependency_injection.iface.Wizard;
import com.sensiblemetrics.api.alpenidos.core.dependency_injection.model.Tobacco;

/**
 * AdvancedSorceress implements inversion of control. It depends on abstraction that can be injected
 * through its setter.
 */
public class AdvancedSorceress implements Wizard {

    private Tobacco tobacco;

    public void setTobacco(final Tobacco tobacco) {
        this.tobacco = tobacco;
    }

    @Override
    public void smoke() {
        this.tobacco.smoke(this);
    }
}
