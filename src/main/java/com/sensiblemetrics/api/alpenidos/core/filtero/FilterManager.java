//package com.sensiblemetrics.api.alpenidos.core.filter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class FilterManager {
//
//    public static void process(final HttpServletRequest request, final HttpServletResponse response, final OnIntercept callback) throws ServletException {
//        FilterChain filterChain = new FilterChainImpl(new AuthenticationFilter(callback), new VisitorCounterFilter());
//        filterChain.doFilter(request, response);
//    }
//}
