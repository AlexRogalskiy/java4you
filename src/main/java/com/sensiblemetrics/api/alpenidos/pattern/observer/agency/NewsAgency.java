package com.sensiblemetrics.api.alpenidos.pattern.observer.agency;

import com.sensiblemetrics.api.alpenidos.pattern.observer.iface.Channel;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {
    private String news;
    private final List<Channel> channels = new ArrayList<>();

    public void addObserver(final Channel channel) {
        this.channels.add(channel);
    }

    public void removeObserver(final Channel channel) {
        this.channels.remove(channel);
    }

    public void setNews(final String news) {
        this.news = news;
        this.channels.forEach(c -> c.update(this.news));
    }
}
