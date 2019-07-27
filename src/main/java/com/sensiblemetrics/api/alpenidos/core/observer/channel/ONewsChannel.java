package com.sensiblemetrics.api.alpenidos.core.observer.channel;

import lombok.Data;

import java.util.Observable;
import java.util.Observer;

@Data
public class ONewsChannel implements Observer {

    private String news;

    @Override
    public void update(final Observable o, final Object news) {
        this.setNews((String) news);
    }
}
