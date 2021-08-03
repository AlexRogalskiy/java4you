package com.sensiblemetrics.api.alpenidos.pattern.simple_factory.impl;

import com.sensiblemetrics.api.alpenidos.pattern.simple_factory.iface.TV;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HisenseTV implements TV {

    public void play() {
        log.info("º£ÐÅµçÊÓ»ú²¥·ÅÖÐ......");
    }
}
