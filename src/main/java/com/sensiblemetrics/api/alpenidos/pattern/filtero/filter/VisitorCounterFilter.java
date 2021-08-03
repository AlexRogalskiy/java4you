//package com.sensiblemetrics.api.alpenidos.core.filtero;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//public class VisitorCounterFilter implements Filter {
//    private static Set<String> users = new HashSet<>();
//
//    @Override
//    public void init(final FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws ServletException {
//        final HttpSession session = ((HttpServletRequest) request).getSession(false);
//        Optional.ofNullable(session.getAttribute("username"))
//            .map(Object::toString)
//            .ifPresent(users::add);
//        request.setAttribute("counter", users.size());
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//    }
//}
