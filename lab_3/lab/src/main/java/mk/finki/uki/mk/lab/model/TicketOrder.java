package mk.finki.uki.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Data
@Entity
public class TicketOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime orderDate;
    private String movieTitle;
    private Long numberOfTickets;


    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public TicketOrder() {
    }

    public TicketOrder(String movieTitle, User user, Long numberOfTickets) {
        this.movieTitle = movieTitle;
        this.numberOfTickets = numberOfTickets;
        this.user=user;
    }
}
