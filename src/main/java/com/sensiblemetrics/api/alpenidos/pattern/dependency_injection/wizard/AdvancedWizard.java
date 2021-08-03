package com.sensiblemetrics.api.alpenidos.pattern.dependency_injection.wizard;

import com.sensiblemetrics.api.alpenidos.pattern.dependency_injection.iface.Wizard;
import com.sensiblemetrics.api.alpenidos.pattern.dependency_injection.model.Tobacco;
import lombok.RequiredArgsConstructor;

/**
 * AdvancedWizard implements inversion of control. It depends on abstraction that can be injected
 * through its constructor.
 */
@RequiredArgsConstructor
public class AdvancedWizard implements Wizard {
    private final Tobacco tobacco;

    @Override
    public void smoke() {
        this.tobacco.smoke(this);
    }
}
