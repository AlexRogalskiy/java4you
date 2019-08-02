package com.sensiblemetrics.api.alpenidos.core.filtero.iface;

import com.sensiblemetrics.api.alpenidos.core.filtero.impl.BookImpl;

import java.util.List;

public interface Bookshelf {

    default void init() {
        add(new BookImpl("001", "Wilson, Robert Anton & Shea, Robert", "Illuminati", 9.99));
        add(new BookImpl("002", "Fowler, Martin", "Patterns of Enterprise TemplateMethodPatternLoader Architecture", 27.88));
        add(new BookImpl("003", "Unknown", "Something about German Umlauts (äüö) and ß", 5.49));
    }

    <E extends Book> boolean add(final E book);

    Book get(final String isbn);

    List<Book> find(final String q);
}
