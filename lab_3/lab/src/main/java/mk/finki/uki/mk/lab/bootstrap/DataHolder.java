package mk.finki.uki.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.uki.mk.lab.model.Movie;
import mk.finki.uki.mk.lab.model.Production;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Movie> movies= new ArrayList<>();
    public static List<Production> productions= new ArrayList<>();

    @PostConstruct
    public void init(){
        productions.add(new Production("Warner Bros. Studios", "United States", " 4000 Warner Blvd, Burbank, CA 91522"));
        productions.add(new Production("Studio Ghibli", "Japan", "1-4-25 Kajino-cho, Koganei City, Tokyo 184-0002"));
        productions.add(new Production("BBC Studios", "United Kingdom", "1 Television Centre, 101 Wood Lane, London W12 7FA, UK"));
        productions.add(new Production("Bollywood Film Company", "India", "Mumbai, Maharashtra, India"));
        productions.add(new Production("Cinecittà Studios", "Italy", "Via Tuscolana, 1055, 00173 Roma RM, Italy"));

        movies.add(new Movie("The Shawshank Redemption", "Drama", 9.3, DataHolder.productions.get(0)));
        movies.add(new Movie("The Godfather", "Criminal", 9.2, DataHolder.productions.get(1)));
        movies.add(new Movie("The Dark Knight", "Action", 9.0, DataHolder.productions.get(2)));
        movies.add(new Movie("Pulp Fiction", "Criminal", 8.9, DataHolder.productions.get(3)));
        movies.add(new Movie("Forrest Gump", "Drama", 8.8, DataHolder.productions.get(4)));
        movies.add(new Movie("Inception", "Science fiction", 8.8,DataHolder.productions.get(0)));
        movies.add(new Movie("The Matrix", "Science fiction", 8.7, DataHolder.productions.get(1)));
        movies.add(new Movie("Gladiator", "Action", 8.5, DataHolder.productions.get(2)));
        movies.add(new Movie("The Silence of the Lambs", "Trailer", 8.6, DataHolder.productions.get(3)));
        movies.add(new Movie("Titanic", "Romance", 7.8, DataHolder.productions.get(4)));

    }
}
