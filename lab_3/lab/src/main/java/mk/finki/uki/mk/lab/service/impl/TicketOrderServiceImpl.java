package mk.finki.uki.mk.lab.service.impl;

import mk.finki.uki.mk.lab.model.TicketOrder;
import mk.finki.uki.mk.lab.model.User;
import mk.finki.uki.mk.lab.repository.jpa.TicketOrderRepository;
import mk.finki.uki.mk.lab.service.TicketOrderService;
import mk.finki.uki.mk.lab.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketOrderServiceImpl implements TicketOrderService {

    private final TicketOrderRepository ticketOrderRepository;
    private final UserService userService;

    public TicketOrderServiceImpl(TicketOrderRepository ticketOrderRepository, UserService userService) {
        this.ticketOrderRepository = ticketOrderRepository;
        this.userService = userService;
    }

    @Override
    public TicketOrder placeOrder(String movieTitle, User user, int numberOfTickets, LocalDateTime orderDate) {
        User user1=userService.findByUsername(user.getUsername());
        TicketOrder ticketOrder= new TicketOrder(movieTitle, user1, (long)numberOfTickets);
        ticketOrder.setOrderDate(orderDate);
        return this.ticketOrderRepository.save(ticketOrder);
    }


    @Override
    public List<TicketOrder> getOrdersBetween(LocalDateTime from, LocalDateTime to) {
        return ticketOrderRepository.findByOrderDateBetween(from, to);
    }

    @Override
    public Optional<TicketOrder> findById(long id) {
        return ticketOrderRepository.findById(id);
    }

    @Override
    public TicketOrder placeOrder(TicketOrder order) {
        return this.ticketOrderRepository.save(order);
    }

}
