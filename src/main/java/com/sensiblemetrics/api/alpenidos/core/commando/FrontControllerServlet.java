//package com.sensiblemetrics.api.alpenidos.core.commando;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class FrontControllerServlet extends HttpServlet {
//    @Override
//    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
//        final FrontCommand command = this.getCommand(request);
//        command.init(getServletContext(), request, response);
//        command.process();
//    }
//
//    private FrontCommand getCommand(final HttpServletRequest request) {
//        try {
//            final Class type = Class.forName(String.format("com.baeldung.patterns.front.controller.commands.%sCommand", request.getParameter("command")));
//            return (FrontCommand) type.asSubclass(FrontCommand.class).getConstructor().newInstance();
//        } catch (Exception e) {
//            return new UnknownCommand();
//        }
//    }
//}
