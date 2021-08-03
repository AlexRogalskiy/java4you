package com.sensiblemetrics.api.alpenidos.pattern.prototype3.impl;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
public class Attachment implements Serializable {

    public void download() {
        log.info("Download attachment");
    }
}
