package com.sensiblemetrics.api.alpenidos.pattern.observer.agency;

import java.util.Observable;

public class ONewsAgency extends Observable {
    private String news;

    public void setNews(final String news) {
        this.news = news;
        this.setChanged();
        this.notifyObservers(news);
    }
}
