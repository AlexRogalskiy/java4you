//package com.sensiblemetrics.api.alpenidos.core.filter;
//
//import com.baeldung.patterns.intercepting.filter.commands.FrontCommand;
//import com.baeldung.patterns.intercepting.filter.commands.LoginCommand;
//import lombok.RequiredArgsConstructor;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.util.Objects;
//
//@RequiredArgsConstructor
//public class AuthenticationFilter implements Filter {
//    private final OnIntercept callback;
//
//    @Override
//    public void init(final FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws ServletException {
//        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        final HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        final HttpSession session = httpServletRequest.getSession(false);
//        if (Objects.isNull(session) || session.getAttribute("username") == null) {
//            this.callback.intercept();
//            final FrontCommand command = new LoginCommand();
//            command.init(httpServletRequest, httpServletResponse);
//            command.process();
//        } else {
//            chain.doFilter(request, response);
//        }
//    }
//
//    @Override
//    public void destroy() {
//    }
//}
