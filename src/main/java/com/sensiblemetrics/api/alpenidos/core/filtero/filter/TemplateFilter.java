//package com.sensiblemetrics.api.alpenidos.core.filtero;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public abstract class TemplateFilter extends BaseFilter {
//    protected abstract void preFilter(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException;
//
//    protected abstract void postFilter(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException;
//
//    @Override
//    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
//        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        final HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        preFilter(httpServletRequest, httpServletResponse);
//        chain.doFilter(request, response);
//        postFilter(httpServletRequest, httpServletResponse);
//    }
//}
