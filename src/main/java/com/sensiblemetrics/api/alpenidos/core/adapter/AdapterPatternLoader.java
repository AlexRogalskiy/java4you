package com.sensiblemetrics.api.alpenidos.core.adapter;

import com.sensiblemetrics.api.alpenidos.core.adapter.impl.MovableAdapterImpl;
import com.sensiblemetrics.api.alpenidos.core.adapter.model.AstonMartin;
import com.sensiblemetrics.api.alpenidos.core.adapter.model.BugattiVeyron;
import com.sensiblemetrics.api.alpenidos.core.adapter.model.McLaren;
import com.sensiblemetrics.api.alpenidos.core.adapter.iface.Movable;
import com.sensiblemetrics.api.alpenidos.core.adapter.iface.MovableAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AdapterPatternLoader {

    public static void main(final String args[]) {
        final Movable bugattiVeyron = new BugattiVeyron();
        final MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);
        log.info("Bugatti Veyron Super Sport's top speed is " + bugattiVeyronAdapter.getSpeed() + " Kmph.");

        final Movable mcLaren = new McLaren();
        final MovableAdapter mcLarenAdapter = new MovableAdapterImpl(mcLaren);
        log.info("McLaren F1 top speed is " + mcLarenAdapter.getSpeed() + " Kmph.");

        final Movable astonMartin = new AstonMartin();
        final MovableAdapter astonMartinAdapter = new MovableAdapterImpl(astonMartin);
        log.info("McLaren F1 top speed is " + astonMartinAdapter.getSpeed() + " Kmph.");
    }
}
