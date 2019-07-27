package com.sensiblemetrics.api.alpenidos.core.locator.impl;

import com.sensiblemetrics.api.alpenidos.core.locator.service.EmailService;
import com.sensiblemetrics.api.alpenidos.core.locator.service.SMSService;

public class InitialContext {

    public Object lookup(final String serviceName) {
        if (serviceName.equalsIgnoreCase("EmailService")) {
            return new EmailService();
        } else if (serviceName.equalsIgnoreCase("SMSService")) {
            return new SMSService();
        }
        return null;
    }
}
