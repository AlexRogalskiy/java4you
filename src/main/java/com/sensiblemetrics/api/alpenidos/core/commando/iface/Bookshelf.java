package com.sensiblemetrics.api.alpenidos.core.commando.iface;

import com.sensiblemetrics.api.alpenidos.core.commando.impl.BookImpl;

public interface Bookshelf {

    default void init() {
        this.add(new BookImpl("Wilson, Robert Anton & Shea, Robert", "Illuminati", 9.99));
        this.add(new BookImpl("Fowler, Martin", "Patterns of Enterprise TemplateMethodPatternLoader Architecture", 27.88));
    }

    Bookshelf getInstance();

    <E extends Book> boolean add(final E book);

    Book findByTitle(final String title);
}
