//package com.sensiblemetrics.api.alpenidos.core.filtero.command;
//
//import com.baeldung.patterns.intercepting.filter.data.Book;
//import com.baeldung.patterns.intercepting.filter.data.Bookshelf;
//
//import javax.servlet.ServletException;
//import java.io.IOException;
//import java.util.Collections;
//
//public class ShowCommand extends FrontCommand {
//    @Override
//    public void process() throws ServletException, IOException {
//        super.process();
//        final Bookshelf bookshelf = (Bookshelf) request.getServletContext().getAttribute("bookshelf");
//        final String title = request.getParameter("isbn");
//        final Book book = bookshelf.get(title);
//        request.setAttribute("books", Collections.singletonList(book));
//        forward("book-found");
//    }
//}
