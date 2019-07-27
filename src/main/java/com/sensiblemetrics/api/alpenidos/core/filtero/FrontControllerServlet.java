//package com.sensiblemetrics.api.alpenidos.core.filter;
//
//import com.baeldung.patterns.intercepting.filter.commands.FrontCommand;
//import com.baeldung.patterns.intercepting.filter.commands.UnknownCommand;
//import com.baeldung.patterns.intercepting.filter.data.Bookshelf;
//import com.baeldung.patterns.intercepting.filter.data.BookshelfImpl;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(name = "intercepting-filter", urlPatterns = "/")
//public class FrontControllerServlet extends HttpServlet {
//    @Override
//    public void init(final ServletConfig config) throws ServletException {
//        super.init(config);
//        final Bookshelf bookshelf = new BookshelfImpl();
//        bookshelf.init();
//        getServletContext().setAttribute("bookshelf", bookshelf);
//    }
//
//    @Override
//    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException {
//        this.doCommand(request, response);
//    }
//
//    @Override
//    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException {
//        this.doCommand(request, response);
//    }
//
//    private void doCommand(final HttpServletRequest request, final HttpServletResponse response) throws ServletException {
//        final FrontCommand command = this.getCommand(request);
//        command.init(request, response);
//        command.process();
//    }
//
//    private FrontCommand getCommand(final HttpServletRequest request) {
//        try {
//            Class type = Class.forName(String.format("com.baeldung.patterns.intercepting.filter.commands.%sCommand", request.getParameter("command")));
//            return (FrontCommand) type.asSubclass(FrontCommand.class).getConstructor().newInstance();
//        } catch (Exception e) {
//            return new UnknownCommand();
//        }
//    }
//}
