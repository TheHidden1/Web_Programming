package mk.finki.uki.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.uki.mk.lab.model.TicketOrder;
import mk.finki.uki.mk.lab.service.MovieService;
import mk.finki.uki.mk.lab.service.TicketOrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "TicketOrderServlet", urlPatterns = "/ticketOrder")
public class TicketOrderServlet extends HttpServlet {
    private final MovieService movieService;
    private final TicketOrderService ticketOrderService;
    private final SpringTemplateEngine springTemplateEngine;

    public TicketOrderServlet(MovieService movieService, TicketOrderService ticketOrderService, SpringTemplateEngine springTemplateEngine) {
        this.movieService = movieService;
        this.ticketOrderService = ticketOrderService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String movieTitle = req.getParameter("movieTitle");
        int numberOfTickets= Integer.parseInt(req.getParameter("numberOfTickets"));
        String IpAddress= req.getRemoteAddr();

        TicketOrder order= ticketOrderService.placeOrder(movieTitle, "George Sivevski", IpAddress, numberOfTickets);

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context= new WebContext(webExchange);
        context.setVariable("IpAddress", IpAddress);
        context.setVariable("order", order);

        springTemplateEngine.process("orderConfirmation.html", context, resp.getWriter());
    }
}
