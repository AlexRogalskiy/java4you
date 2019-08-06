package com.sensiblemetrics.api.alpenidos.core.simple_factory.impl;

import com.sensiblemetrics.api.alpenidos.core.simple_factory.iface.TV;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HaierTV implements TV {
    public void play() {
        log.info("º£¶ûµçÊÓ»ú²¥·ÅÖÐ......");
    }
}
