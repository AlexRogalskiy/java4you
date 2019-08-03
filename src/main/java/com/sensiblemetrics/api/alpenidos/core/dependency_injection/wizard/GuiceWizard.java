package com.sensiblemetrics.api.alpenidos.core.dependency_injection.wizard;

import com.sensiblemetrics.api.alpenidos.core.dependency_injection.iface.Wizard;
import com.sensiblemetrics.api.alpenidos.core.dependency_injection.model.Tobacco;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * GuiceWizard implements inversion of control. Its dependencies are injected through its
 * constructor by Guice framework.
 */
@Component
@RequiredArgsConstructor
public class GuiceWizard implements Wizard {
    private final Tobacco tobacco;

    @Override
    public void smoke() {
        this.tobacco.smoke(this);
    }
}
