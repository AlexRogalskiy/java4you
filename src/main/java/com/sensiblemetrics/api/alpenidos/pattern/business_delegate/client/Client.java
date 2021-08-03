package com.sensiblemetrics.api.alpenidos.pattern.business_delegate.client;

import com.sensiblemetrics.api.alpenidos.pattern.business_delegate.delegate.BusinessDelegate;
import lombok.RequiredArgsConstructor;

/**
 * SimpleFactoryPatternLoader utilizes BusinessDelegate to call the business tier
 */
@RequiredArgsConstructor
public class Client {
    private final BusinessDelegate businessDelegate;

    public void doTask() {
        this.businessDelegate.doTask();
    }
}
