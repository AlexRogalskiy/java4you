package com.sensiblemetrics.api.alpenidos.core.commando.iface;

public interface Book {

    String getAuthor();

    void setAuthor(final String author);

    String getTitle();

    void setTitle(final String title);

    Double getPrice();

    void setPrice(final Double price);
}
