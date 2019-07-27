//package com.sensiblemetrics.api.alpenidos.core.filtero.command;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpSession;
//import java.util.Optional;
//
//public class LoginCommand extends FrontCommand {
//    @Override
//    public void process() throws ServletException {
//        if (request.getMethod().equals("POST")) {
//            final HttpSession session = request.getSession(true);
//            session.setAttribute("username", request.getParameter("username"));
//            response.sendRedirect(request.getParameter("redirect"));
//        } else {
//            final String queryString = Optional.ofNullable(request.getQueryString()).orElse("command=Home");
//            request.setAttribute("redirect", request.getRequestURL().append("?").append(queryString).toString());
//            forward("login");
//        }
//    }
//}
