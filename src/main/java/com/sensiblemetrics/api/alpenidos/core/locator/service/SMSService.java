package com.sensiblemetrics.api.alpenidos.core.locator.service;

import com.sensiblemetrics.api.alpenidos.core.locator.iface.MessagingService;

public class SMSService implements MessagingService {

    public String getMessageBody() {
        return "sms message";
    }

    public String getServiceName() {
        return "SMSService";
    }
}
