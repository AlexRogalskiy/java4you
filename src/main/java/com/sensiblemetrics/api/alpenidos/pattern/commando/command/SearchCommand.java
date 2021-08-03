//package com.sensiblemetrics.api.alpenidos.core.commando;
//
//import com.sensiblemetrics.api.alpenidos.core.commando.iface.Book;
//
//import javax.servlet.ServletException;
//import java.io.IOException;
//import java.util.Objects;
//
//public class SearchCommand extends FrontCommand {
//
//    @Override
//    public void process() throws ServletException, IOException {
//        final Book book = new BookshelfImpl().getInstance().findByTitle(request.getParameter("title"));
//        if (Objects.nonNull(book)) {
//            request.setAttribute("book", book);
//            forward("book-found");
//        } else {
//            forward("book-notfound");
//        }
//    }
//}
