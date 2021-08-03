package com.sensiblemetrics.api.alpenidos.pattern.cqrs.query;

import com.sensiblemetrics.api.alpenidos.pattern.cqrs.model.Author;
import com.sensiblemetrics.api.alpenidos.pattern.cqrs.model.Book;

import java.math.BigInteger;
import java.util.List;

/**
 * This interface represents the query methods of the CQRS pattern
 */
public interface IQueryService {

    Author getAuthorByUsername(final String username);

    Book getBook(final String title);

    List<Book> getAuthorBooks(final String username);

    BigInteger getAuthorBooksCount(final String username);

    BigInteger getAuthorsCount();
}
