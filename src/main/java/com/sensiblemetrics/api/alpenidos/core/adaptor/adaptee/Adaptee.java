package com.sensiblemetrics.api.alpenidos.core.adaptor.adaptee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Adaptee {

    public void onRequest() {
        log.info("Adaptee.onRequest()");
    }
}
