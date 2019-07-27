package com.sensiblemetrics.api.alpenidos.core.filtero.iface;

public interface Book {

    String getIsbn();

    void setIsbn(final String isbn);

    String getAuthor();

    void setAuthor(final String author);

    String getTitle();

    void setTitle(final String title);

    Double getPrice();

    void setPrice(final Double price);
}
