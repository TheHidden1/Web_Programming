package mk.finki.uki.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.uki.mk.lab.model.ShoppingCart;
import mk.finki.uki.mk.lab.model.TicketOrder;
import mk.finki.uki.mk.lab.model.User;
import mk.finki.uki.mk.lab.service.ShoppingCartService;
import mk.finki.uki.mk.lab.service.TicketOrderService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/ticketOrder")
public class TicketOrderController {
    private final TicketOrderService ticketOrderService;
    private final ShoppingCartService shoppingCartService;

    public TicketOrderController(TicketOrderService ticketOrderService, ShoppingCartService shoppingCartService) {
        this.ticketOrderService = ticketOrderService;
        this.shoppingCartService = shoppingCartService;
    }


    @PostMapping
    public String submitOrder(@RequestParam String movieTitle,
                              @RequestParam int numTickets,
                              @RequestParam LocalDateTime orderDateTime,
                              Model model, HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        TicketOrder order= ticketOrderService.placeOrder(movieTitle, user, numTickets, orderDateTime);
        ticketOrderService.placeOrder(order);
        System.out.println(user.getUsername());

        model.addAttribute("user", user);
        model.addAttribute("order", order);
        model.addAttribute("selectedMovie", movieTitle);
        model.addAttribute("numTickets", numTickets);

        return "orderConfirmation";
    }
    @PostMapping("/filter")
    public String filterOrders(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to,
                               Model model) {
        List<TicketOrder> ticketOrders = ticketOrderService.getOrdersBetween(from, to);
        model.addAttribute("orders", ticketOrders);
        return "ordersBetween";
    }
    @PostMapping("/addToCart")
    public String addOrderToCart(@RequestParam long orderId,
                                 Model model, HttpServletRequest req){


        User user = (User) req.getSession().getAttribute("user");

        TicketOrder order= ticketOrderService.findById(orderId).get();

        shoppingCartService.addTicketOrderToCart(user.getUsername(), order.getId());
        ShoppingCart cart=shoppingCartService.getShoppingCartsForUser(user);

        model.addAttribute("cart", cart);
        return "redirect:/cart";
    }

}
