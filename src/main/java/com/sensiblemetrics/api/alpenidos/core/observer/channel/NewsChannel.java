package com.sensiblemetrics.api.alpenidos.core.observer.channel;

import com.sensiblemetrics.api.alpenidos.core.observer.iface.Channel;
import lombok.Data;

@Data
public class NewsChannel implements Channel {

    private String news;

    @Override
    public void update(final Object news) {
        this.setNews((String) news);
    }
}
