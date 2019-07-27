//package com.sensiblemetrics.api.alpenidos.core.filter;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import java.util.Optional;
//
//@WebFilter(servletNames = "intercepting-filter")
//public class LoggingFilter extends BaseFilter {
//    private static final Logger log = LoggerFactory.getLogger(LoggingFilter.class);
//
//    @Override
//    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws ServletException {
//        chain.doFilter(request, response);
//        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        final String username = Optional
//            .ofNullable(httpServletRequest.getAttribute("username"))
//            .map(Object::toString)
//            .orElse("guest");
//        log.info("Request from '{}@{}': {}?{}", username, request.getRemoteAddr(), httpServletRequest.getRequestURI(), request.getParameterMap());
//    }
//}
