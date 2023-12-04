package mk.finki.uki.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateCreated;
    @ManyToMany
    private List<TicketOrder> ticketOrders;

    public ShoppingCart() {
    }

    public ShoppingCart(User user) {
        this.dateCreated = LocalDateTime.now();
        this.user = user;
        this.ticketOrders= new ArrayList<>();

    }


}
