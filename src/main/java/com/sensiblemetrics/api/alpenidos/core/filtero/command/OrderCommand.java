//package com.sensiblemetrics.api.alpenidos.core.filtero.command;
//
//import com.baeldung.patterns.intercepting.filter.data.Book;
//import com.baeldung.patterns.intercepting.filter.data.Bookshelf;
//import com.baeldung.patterns.intercepting.filter.data.Order;
//import com.baeldung.patterns.intercepting.filter.data.OrderImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpSession;
//import java.util.Optional;
//
//public class OrderCommand extends FrontCommand {
//    @Override
//    public void process() throws ServletException {
//        super.process();
//        if (request.getMethod().equals("POST")) {
//            final HttpSession session = request.getSession(false);
//            final Order order = Optional
//                .ofNullable(session.getAttribute("order"))
//                .map(Order.class::cast)
//                .orElseGet(() -> new OrderImpl((String) session.getAttribute("username")));
//
//            final Bookshelf bookshelf = (Bookshelf) request.getServletContext().getAttribute("bookshelf");
//            final String isbn = request.getParameter("isbn");
//            final Integer quantity = Integer.parseInt(request.getParameter("quantity"));
//            final Book book = bookshelf.get(isbn);
//            order.add(book, quantity);
//            session.setAttribute("order", order);
//            response.sendRedirect(String.format("/?command=Show&isbn=%s", isbn));
//        }
//    }
//}
