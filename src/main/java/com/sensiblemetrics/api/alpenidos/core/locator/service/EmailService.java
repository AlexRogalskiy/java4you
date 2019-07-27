package com.sensiblemetrics.api.alpenidos.core.locator.service;

import com.sensiblemetrics.api.alpenidos.core.locator.iface.MessagingService;

public class EmailService implements MessagingService {

    public String getMessageBody() {
        return "email message";
    }

    public String getServiceName() {
        return "EmailService";
    }
}
