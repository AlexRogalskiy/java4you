//package com.sensiblemetrics.api.alpenidos.core.filter;
//
//import javax.servlet.*;
//import java.util.Arrays;
//import java.util.Iterator;
//
//public class FilterChainImpl implements FilterChain {
//    private Iterator<Filter> filters;
//
//    public FilterChainImpl(final Filter... filters) {
//        this.filters = Arrays.asList(filters).iterator();
//    }
//
//    @Override
//    public void doFilter(final ServletRequest request, final ServletResponse response) throws ServletException {
//        if (this.filters.hasNext()) {
//            Filter filter = filters.next();
//            filter.doFilter(request, response, this);
//        }
//    }
//}
