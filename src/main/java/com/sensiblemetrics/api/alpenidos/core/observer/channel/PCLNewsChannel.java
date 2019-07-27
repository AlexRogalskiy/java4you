package com.sensiblemetrics.api.alpenidos.core.observer.channel;

import lombok.Data;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Data
public class PCLNewsChannel implements PropertyChangeListener {

    private String news;

    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        this.setNews((String) evt.getNewValue());
    }
}
