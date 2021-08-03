//package com.sensiblemetrics.api.alpenidos.core.filtero.command;
//
//import javax.servlet.ServletException;
//import java.util.Optional;
//
//public class LogoutCommand extends FrontCommand {
//
//    @Override
//    public void process() throws ServletException {
//        super.process();
//        Optional.ofNullable(request.getSession(false))
//            .ifPresent(session -> {
//                session.removeAttribute("username");
//                session.removeAttribute("order");
//            });
//        response.sendRedirect("/?command=Home");
//    }
//}
