package mk.finki.uki.mk.lab.service;

import mk.finki.uki.mk.lab.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {
    List<Movie> listAll();
    List<Movie> searchMovies(String text);
    List<Movie> searchMoviesByRating(int rating);
    Optional<Movie> findById(Long id);

    Optional<Movie> saveMovie(String movieTitle, String summary, double rating, Long productionId);

    void deleteById(Long id);
}
