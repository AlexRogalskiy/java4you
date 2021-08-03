//package com.sensiblemetrics.api.alpenidos.core.filtero.command;
//
//import com.baeldung.patterns.intercepting.filter.data.Order;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpSession;
//
//public class CheckoutCommand extends FrontCommand {
//
//    @Override
//    public void process() throws ServletException {
//        super.process();
//        final HttpSession session = request.getSession(false);
//        if (request.getMethod().equals("POST")) {
//            session.removeAttribute("order");
//            response.sendRedirect("/?command=Home&message=Thank you for buying!");
//        } else {
//            final Order order = (Order) session.getAttribute("order");
//            final Double total = order.getItems().entrySet().stream()
//                .map(entry -> entry.getKey().getPrice() * entry.getValue())
//                .reduce((p1, p2) -> p1 + p2)
//                .orElse(0.00);
//            request.setAttribute("total", total);
//            forward("shopping-cart");
//        }
//    }
//}
