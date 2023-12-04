//package mk.finki.uki.mk.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.uki.mk.lab.model.TicketOrder;
//import mk.finki.uki.mk.lab.model.User;
//import mk.finki.uki.mk.lab.service.MovieService;
//import mk.finki.uki.mk.lab.service.TicketOrderService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//
//@WebServlet(name = "TicketOrderServlet", urlPatterns = "/servlet/ticketOrder")
//public class TicketOrderServlet extends HttpServlet {
//    private final TicketOrderService ticketOrderService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public TicketOrderServlet(MovieService movieService, TicketOrderService ticketOrderService, SpringTemplateEngine springTemplateEngine) {
//        this.ticketOrderService = ticketOrderService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String movieTitle = req.getParameter("movieTitle");
//        int numberOfTickets= Integer.parseInt(req.getParameter("numTickets"));
//        String IpAddress= req.getRemoteAddr();
//        User user= new User();
//        LocalDateTime orderDate
//        TicketOrder order= ticketOrderService.placeOrder(movieTitle,user,numberOfTickets, orderDate);
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context= new WebContext(webExchange);
//        context.setVariable("IpAddress", IpAddress);
//        context.setVariable("order", order);
//
//        springTemplateEngine.process("orderConfirmation.html", context, resp.getWriter());
//    }
//}
