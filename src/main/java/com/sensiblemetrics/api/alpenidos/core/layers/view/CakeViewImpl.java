package com.sensiblemetrics.api.alpenidos.core.layers.view;

import com.sensiblemetrics.api.alpenidos.core.layers.service.CakeBakingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * View implementation for displaying cakes
 */
@Slf4j
@RequiredArgsConstructor
public class CakeViewImpl implements View {
    private final CakeBakingService cakeBakingService;

    public void render() {
        this.cakeBakingService.getAllCakes().forEach(cake -> log.info(String.valueOf(cake)));
    }
}
