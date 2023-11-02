package mk.finki.uki.mk.lab.service;

import mk.finki.uki.mk.lab.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MovieService {
    List<Movie> listAll();
    List<Movie> searchMovies(String text);
}
