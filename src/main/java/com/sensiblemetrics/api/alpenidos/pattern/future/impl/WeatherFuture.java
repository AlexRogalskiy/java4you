package com.sensiblemetrics.api.alpenidos.pattern.future.impl;

import com.sensiblemetrics.api.alpenidos.pattern.future.iface.IWeatherFetch;
import com.sensiblemetrics.api.alpenidos.pattern.future.model.Coordinate;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * <p>
 * Date: Aug 22, 2011
 *
 * @author moleksyuk
 */
public class WeatherFuture {
    private Coordinate location;
    private IWeatherFetch fetcher;
    private AsynchronousFuture futureSupport;

    public WeatherFuture(final IWeatherFetch fetcher, final Coordinate location) {
        this.fetcher = fetcher;
        this.location = location;
        this.futureSupport = new AsynchronousFuture();
        new Runner().start();
    }

    public boolean check() {
        return futureSupport.checkResult();
    }

    public synchronized IWeatherFetch waitForWeather() throws Exception {
        return (IWeatherFetch) this.futureSupport.getResult();
    }

    private class Runner extends Thread {
        @Override
        public void run() {
            try {
                final IWeatherFetch info = fetcher.fetchWeather(location);
                futureSupport.setResult(info);
            } catch (Exception e) {
                futureSupport.setException(e);
            }
        }
    }
}
