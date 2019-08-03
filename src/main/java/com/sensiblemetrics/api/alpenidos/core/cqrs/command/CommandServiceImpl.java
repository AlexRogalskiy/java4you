//package com.sensiblemetrics.api.alpenidos.core.cqrs.command;
//
//import com.iluwatar.cqrs.util.HibernateUtil;
//import com.sensiblemetrics.api.alpenidos.core.cqrs.model.Author;
//import com.sensiblemetrics.api.alpenidos.core.cqrs.model.Book;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
///**
// * This class is an implementation of {@link ICommandService} interface. It uses Hibernate as an api for persistence.
// */
//public class CommandServiceImpl implements ICommandService {
//
//    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//
//    private Author getAuthorByUsername(final String username) {
//        Author author = null;
//        try (final Session session = sessionFactory.openSession()) {
//            final Query query = session.createQuery("from Author where username=:username");
//            query.setParameter("username", username);
//            author = (Author) query.uniqueResult();
//        }
//        if (author == null) {
//            HibernateUtil.getSessionFactory().close();
//            throw new NullPointerException("Author " + username + " doesn't exist!");
//        }
//        return author;
//    }
//
//    private Book getBookByTitle(final String title) {
//        Book book = null;
//        try (final Session session = sessionFactory.openSession()) {
//            final Query query = session.createQuery("from Book where title=:title");
//            query.setParameter("title", title);
//            book = (Book) query.uniqueResult();
//        }
//        if (book == null) {
//            HibernateUtil.getSessionFactory().close();
//            throw new NullPointerException("Book " + title + " doesn't exist!");
//        }
//        return book;
//    }
//
//    @Override
//    public void authorCreated(final String username, final String name, final String email) {
//        final Author author = new Author(username, name, email);
//        try (final Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            session.save(author);
//            session.getTransaction().commit();
//        }
//    }
//
//    @Override
//    public void bookAddedToAuthor(final String title, final double price, final String username) {
//        Author author = getAuthorByUsername(username);
//        Book book = new Book(title, price, author);
//        try (Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            session.save(book);
//            session.getTransaction().commit();
//        }
//    }
//
//    @Override
//    public void authorNameUpdated(final String username, final String name) {
//        Author author = getAuthorByUsername(username);
//        author.setName(name);
//        try (Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            session.update(author);
//            session.getTransaction().commit();
//        }
//    }
//
//    @Override
//    public void authorUsernameUpdated(final String oldUsername, final String newUsername) {
//        final Author author = getAuthorByUsername(oldUsername);
//        author.setUsername(newUsername);
//        try (final Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            session.update(author);
//            session.getTransaction().commit();
//        }
//    }
//
//    @Override
//    public void authorEmailUpdated(final String username, final String email) {
//        final Author author = getAuthorByUsername(username);
//        author.setEmail(email);
//        try (final Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            session.update(author);
//            session.getTransaction().commit();
//        }
//    }
//
//    @Override
//    public void bookTitleUpdated(final String oldTitle, final String newTitle) {
//        final Book book = getBookByTitle(oldTitle);
//        book.setTitle(newTitle);
//        try (final Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            session.update(book);
//            session.getTransaction().commit();
//        }
//    }
//
//    @Override
//    public void bookPriceUpdated(final String title, final double price) {
//        final Book book = getBookByTitle(title);
//        book.setPrice(price);
//        try (final Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            session.update(book);
//            session.getTransaction().commit();
//        }
//    }
//}
