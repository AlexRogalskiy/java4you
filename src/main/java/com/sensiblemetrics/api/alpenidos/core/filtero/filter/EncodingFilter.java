//package com.sensiblemetrics.api.alpenidos.core.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import java.util.Optional;
//
//@WebFilter(
//    servletNames = {"intercepting-filter"},
//    initParams = {@WebInitParam(name = "encoding", value = "UTF-8")}
//)
//public class EncodingFilter extends BaseFilter {
//    private String encoding;
//
//    @Override
//    public void init(final FilterConfig filterConfig) throws ServletException {
//        super.init(filterConfig);
//        this.encoding = filterConfig.getInitParameter("encoding");
//    }
//
//    @Override
//    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws ServletException {
//        String encoding = Optional
//            .ofNullable(request.getParameter("encoding"))
//            .orElse(this.encoding);
//        response.setCharacterEncoding(encoding);
//        chain.doFilter(request, response);
//    }
//}
