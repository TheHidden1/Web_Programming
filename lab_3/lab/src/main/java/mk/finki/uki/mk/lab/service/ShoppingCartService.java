package mk.finki.uki.mk.lab.service;

import mk.finki.uki.mk.lab.model.ShoppingCart;
import mk.finki.uki.mk.lab.model.TicketOrder;
import mk.finki.uki.mk.lab.model.User;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {

    ShoppingCart getShoppingCartsForUser(User user);
    List<TicketOrder> getAllTicketOrdersFromCart(long id);
    ShoppingCart addTicketOrderToCart(String username, long ticketId);
}
