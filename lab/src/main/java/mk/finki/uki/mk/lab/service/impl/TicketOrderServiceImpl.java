package mk.finki.uki.mk.lab.service.impl;

import mk.finki.uki.mk.lab.model.TicketOrder;
import mk.finki.uki.mk.lab.service.TicketOrderService;
import org.springframework.stereotype.Service;

@Service
public class TicketOrderServiceImpl implements TicketOrderService {
    @Override
    public TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets) {

        return new TicketOrder(movieTitle, clientName, address, (long)numberOfTickets);

    }
}
