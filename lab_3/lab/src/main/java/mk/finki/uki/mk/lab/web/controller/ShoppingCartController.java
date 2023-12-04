package mk.finki.uki.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.uki.mk.lab.model.ShoppingCart;
import mk.finki.uki.mk.lab.model.User;
import mk.finki.uki.mk.lab.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @GetMapping
    public String getCartView(HttpServletRequest req,
                              Model model){
        User user= (User) req.getSession().getAttribute("user");
        ShoppingCart cart= shoppingCartService.getShoppingCartsForUser(user);
        model.addAttribute("orders", this.shoppingCartService.getAllTicketOrdersFromCart(cart.getId()));
        model.addAttribute("cart", cart);
        return "cart";
    }
}
