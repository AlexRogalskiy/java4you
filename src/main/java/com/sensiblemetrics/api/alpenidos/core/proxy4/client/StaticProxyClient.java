package com.sensiblemetrics.api.alpenidos.core.proxy4.client;

import com.sensiblemetrics.api.alpenidos.core.proxy4.impl.ProxySubject;
import com.sensiblemetrics.api.alpenidos.core.proxy4.model.ISubject;

public class StaticProxyClient {

    public static void main(final String[] args) {
        final ISubject subject = new ProxySubject();
        subject.action();
    }
}
