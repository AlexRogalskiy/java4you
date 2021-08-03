//package com.sensiblemetrics.api.alpenidos.core.commando;
//
//import lombok.RequiredArgsConstructor;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@RequiredArgsConstructor
//public abstract class FrontCommand {
//    protected ServletContext context;
//    protected HttpServletRequest request;
//    protected HttpServletResponse response;
//
//    public void init(final ServletContext servletContext, final HttpServletRequest servletRequest, final HttpServletResponse servletResponse) {
//        this.context = servletContext;
//        this.request = servletRequest;
//        this.response = servletResponse;
//    }
//
//    public abstract void process() throws ServletException, IOException;
//
//    protected void forward(final String target) throws ServletException, IOException {
//        final String newTarget = String.format("/WEB-INF/jsp/%s.jsp", target);
//        final RequestDispatcher dispatcher = context.getRequestDispatcher(newTarget);
//        dispatcher.forward(this.request, this.response);
//    }
//}
