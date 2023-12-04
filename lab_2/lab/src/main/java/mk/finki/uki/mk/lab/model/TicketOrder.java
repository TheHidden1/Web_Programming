package mk.finki.uki.mk.lab.model;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@Data
public class TicketOrder {
    private String movieTitle;
    private String clientName;
    private String clientAddress;
    private List<Movie> listMovies;
    private Long numberOfTickets;

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void setNumberOfTickets(Long numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public TicketOrder(String movieTitle, String clientName, String clientAddress, Long numberOfTickets) {
        this.movieTitle = movieTitle;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.numberOfTickets = numberOfTickets;
    }
}
