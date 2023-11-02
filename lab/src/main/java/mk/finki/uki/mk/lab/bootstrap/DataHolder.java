package mk.finki.uki.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.uki.mk.lab.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Movie> movies= new ArrayList<>();

    @PostConstruct
    public void init(){
        movies.add(new Movie("The Shawshank Redemption", "Drama", 9.3));
        movies.add(new Movie("The Godfather", "Criminal", 9.2));
        movies.add(new Movie("The Dark Knight", "Action", 9.0));
        movies.add(new Movie("Pulp Fiction", "Criminal", 8.9));
        movies.add(new Movie("Forrest Gump", "Drama", 8.8));
        movies.add(new Movie("Inception", "Science fiction", 8.8));
        movies.add(new Movie("The Matrix", "Science fiction", 8.7));
        movies.add(new Movie("Gladiator", "Action", 8.5));
        movies.add(new Movie("The Silence of the Lambs", "Trailer", 8.6));
        movies.add(new Movie("Titanic", "Romance", 7.8));
    }
}
