//package com.sensiblemetrics.api.alpenidos.core.filtero.impl;
//
//import com.baeldung.patterns.intercepting.filter.filters.FilterManager;
//import com.sensiblemetrics.api.alpenidos.core.filtero.iface.OnIntercept;
//import lombok.NoArgsConstructor;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@NoArgsConstructor
//public abstract class FrontCommand implements OnIntercept {
//    protected HttpServletRequest request;
//    protected HttpServletResponse response;
//    private boolean intercept;
//
//    public void init(final HttpServletRequest request, final HttpServletResponse response) {
//        this.request = request;
//        this.response = response;
//    }
//
//    public void process() throws ServletException {
//        FilterManager.process(request, response, this);
//    }
//
//    public void forward(final String target) throws ServletException {
//        if (intercept) {
//            return;
//        }
//        String path = String.format("/WEB-INF/jsp/%s.jsp", target);
//        final RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(path);
//        dispatcher.forward(request, response);
//    }
//
//    @Override
//    public void intercept() {
//        this.intercept = true;
//    }
//}
