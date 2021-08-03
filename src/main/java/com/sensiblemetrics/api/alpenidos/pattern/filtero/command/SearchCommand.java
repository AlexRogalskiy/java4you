//package com.sensiblemetrics.api.alpenidos.core.filtero.command;
//
//import com.baeldung.patterns.intercepting.filter.data.Book;
//import com.baeldung.patterns.intercepting.filter.data.Bookshelf;
//
//import javax.servlet.ServletException;
//import java.io.IOException;
//import java.util.List;
//
//public class SearchCommand extends FrontCommand {
//    @Override
//    public void process() throws ServletException, IOException {
//        super.process();
//        final Bookshelf bookshelf = (Bookshelf) request.getServletContext().getAttribute("bookshelf");
//        final String q = request.getParameter("q");
//        final List<Book> books = bookshelf.find(q);
//        if (books.size() > 0) {
//            request.setAttribute("books", books);
//            forward("book-found");
//        } else {
//            forward("book-notfound");
//        }
//    }
//}
