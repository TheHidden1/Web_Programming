package mk.finki.uki.mk.lab.repository.jpa;

import mk.finki.uki.mk.lab.model.TicketOrder;
import mk.finki.uki.mk.lab.model.User;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketOrderRepository extends JpaRepository<TicketOrder, Long> {

    @Override
    TicketOrder save(TicketOrder ticketOrder);

    List<TicketOrder> findByOrderDateBetween(LocalDateTime from, LocalDateTime to);

}
