package com.sensiblemetrics.api.alpenidos.core.observer.agency;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PCLNewsAgency {
    private String news;
    private PropertyChangeSupport support;

    public PCLNewsAgency() {
        this.support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(final PropertyChangeListener pcl) {
        this.support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(final PropertyChangeListener pcl) {
        this.support.removePropertyChangeListener(pcl);
    }

    public void setNews(final String value) {
        this.support.firePropertyChange("news", this.news, value);
        this.news = value;
    }
}
