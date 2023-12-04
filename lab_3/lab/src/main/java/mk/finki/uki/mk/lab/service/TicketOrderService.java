package mk.finki.uki.mk.lab.service;

import mk.finki.uki.mk.lab.model.TicketOrder;
import mk.finki.uki.mk.lab.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface TicketOrderService {
    TicketOrder placeOrder(String movieTitle, User user, int numberOfTickets, LocalDateTime orderDate);
    List<TicketOrder> getOrdersBetween(LocalDateTime from, LocalDateTime to);
    Optional<TicketOrder> findById(long id);
    TicketOrder placeOrder(TicketOrder order);
}
