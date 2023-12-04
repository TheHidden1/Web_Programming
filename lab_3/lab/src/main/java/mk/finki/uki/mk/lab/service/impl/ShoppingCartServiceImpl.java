package mk.finki.uki.mk.lab.service.impl;

import mk.finki.uki.mk.lab.model.ShoppingCart;
import mk.finki.uki.mk.lab.model.TicketOrder;
import mk.finki.uki.mk.lab.model.User;
import mk.finki.uki.mk.lab.model.exceptions.ShoppingCartEmptyException;
import mk.finki.uki.mk.lab.repository.jpa.ShoppingCartRepository;
import mk.finki.uki.mk.lab.service.ShoppingCartService;
import mk.finki.uki.mk.lab.service.TicketOrderService;
import mk.finki.uki.mk.lab.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserService userService;
    private final TicketOrderService ticketOrderService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserService userService, TicketOrderService ticketOrderService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userService = userService;
        this.ticketOrderService = ticketOrderService;
    }

    @Override
    public ShoppingCart getShoppingCartsForUser(User user) {
//        User user= userService.findByUsername(username);
//        Optional<ShoppingCart> cart= shoppingCartRepository.findByUser(user);
//        if(cart.isEmpty()){
//            cart= Optional.of(new ShoppingCart(user));
//        }
//        shoppingCartRepository.save(cart.get());
//        return cart;

        return this.shoppingCartRepository.findByUser(user)
                .orElseGet(()->{
                    ShoppingCart cart= new ShoppingCart(user);
                    return this.shoppingCartRepository.save(cart);
                });
    }

    @Override
    public List<TicketOrder> getAllTicketOrdersFromCart(long id) {
        Optional<ShoppingCart> cart=shoppingCartRepository.findById(id);
        if(cart.isEmpty()){
            throw new ShoppingCartEmptyException();
        }
        return cart.get().getTicketOrders();
    }

    @Override
    public ShoppingCart addTicketOrderToCart(String username, long ticketId) {
        Optional<TicketOrder> order=ticketOrderService.findById(ticketId);
        User user=userService.findByUsername(username);
        Optional<ShoppingCart> cart= shoppingCartRepository.findByUser(user);

        if(cart.isEmpty()){
           cart= Optional.of(new ShoppingCart(user));
        }
        cart.get().getTicketOrders().add(order.get());
        return this.shoppingCartRepository.save(cart.get());

    }
}
