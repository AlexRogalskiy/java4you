//package com.sensiblemetrics.api.alpenidos.core.filtero.command;
//
//import com.baeldung.patterns.intercepting.filter.data.Bookshelf;
//
//import javax.servlet.ServletException;
//
//public class HomeCommand extends FrontCommand {
//    @Override
//    public void process() throws ServletException {
//        super.process();
//        final Bookshelf bookshelf = (Bookshelf) request.getServletContext().getAttribute("bookshelf");
//        request.setAttribute("books", bookshelf);
//        forward("home");
//    }
//}
