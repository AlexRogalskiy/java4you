//package com.sensiblemetrics.api.alpenidos.core.cqrs;
//
//import com.iluwatar.cqrs.commandes.CommandServiceImpl;
//import com.sensiblemetrics.api.alpenidos.core.cqrs.command.ICommandService;
//import com.sensiblemetrics.api.alpenidos.core.cqrs.constants.AppConstants;
//import com.sensiblemetrics.api.alpenidos.core.cqrs.model.Author;
//import com.sensiblemetrics.api.alpenidos.core.cqrs.model.Book;
//import com.sensiblemetrics.api.alpenidos.core.cqrs.query.IQueryService;
//import com.sensiblemetrics.api.alpenidos.core.cqrs.query.QueryServiceImpl;
//import com.sensiblemetrics.api.alpenidos.core.cqrs.util.HibernateUtil;
//import lombok.extern.slf4j.Slf4j;
//
//import java.math.BigInteger;
//import java.util.List;
//
///**
// * CQRS : Command Query Responsibility Segregation. A pattern used to separate query services from commands or writes
// * services. The pattern is very simple but it has many consequences. For example, it can be used to tackle down a
// * complex domain, or to use other architectures that were hard to implement with the classical way.
// * <p>
// * This implementation is an example of managing books and authors in a library. The persistence of books and authors is
// * done according to the CQRS architecture. A command side that deals with a data model to persist(insert,update,delete)
// * objects to a database. And a query side that uses native queries to get data from the database and return objects as
// * DTOs (Data transfer Objects).
// */
//@Slf4j
//public class CqrsPattenLoader {
//
//    /**
//     * Program entry point
//     *
//     * @param args command line args
//     */
//    public static void main(String[] args) {
//        final ICommandService commands = new CommandServiceImpl();
//        // Create Authors and Books using CommandService
//        commands.authorCreated(AppConstants.E_EVANS, "Eric Evans", "eEvans@email.com");
//        commands.authorCreated(AppConstants.J_BLOCH, "Joshua Bloch", "jBloch@email.com");
//        commands.authorCreated(AppConstants.M_FOWLER, "Martin Fowler", "mFowler@email.com");
//
//        commands.bookAddedToAuthor("Domain-Driven Design", 60.08, AppConstants.E_EVANS);
//        commands.bookAddedToAuthor("Effective Java", 40.54, AppConstants.J_BLOCH);
//        commands.bookAddedToAuthor("Java Puzzlers", 39.99, AppConstants.J_BLOCH);
//        commands.bookAddedToAuthor("Java Concurrency in Practice", 29.40, AppConstants.J_BLOCH);
//        commands.bookAddedToAuthor("Patterns of Enterprise Application Architecture", 54.01, AppConstants.M_FOWLER);
//        commands.bookAddedToAuthor("Domain Specific Languages", 48.89, AppConstants.M_FOWLER);
//        commands.authorNameUpdated(AppConstants.E_EVANS, "Eric J. Evans");
//
//        final IQueryService queries = new QueryServiceImpl();
//        // Query the database using QueryService
//        final Author nullAuthor = queries.getAuthorByUsername("username");
//        final Author eEvans = queries.getAuthorByUsername(AppConstants.E_EVANS);
//        BigInteger jBlochBooksCount = queries.getAuthorBooksCount(AppConstants.J_BLOCH);
//        BigInteger authorsCount = queries.getAuthorsCount();
//        final Book dddBook = queries.getBook("Domain-Driven Design");
//        final List<Book> jBlochBooks = queries.getAuthorBooks(AppConstants.J_BLOCH);
//
//        log.info("Author username : {}", nullAuthor);
//        log.info("Author eEvans : {}", eEvans);
//        log.info("jBloch number of books : {}", jBlochBooksCount);
//        log.info("Number of authors : {}", authorsCount);
//        log.info("DDD book : {}", dddBook);
//        log.info("jBloch books : {}", jBlochBooks);
//
//        HibernateUtil.getSessionFactory().close();
//    }
//}
