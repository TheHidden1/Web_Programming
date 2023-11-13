package mk.finki.uki.mk.lab.service;

import mk.finki.uki.mk.lab.model.TicketOrder;
import org.springframework.stereotype.Service;

@Service
public interface TicketOrderService {
    TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets);
}
