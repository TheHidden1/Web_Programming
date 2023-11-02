package mk.finki.uki.mk.lab.service.impl;

import mk.finki.uki.mk.lab.model.Movie;
import mk.finki.uki.mk.lab.repository.MovieRepository;
import mk.finki.uki.mk.lab.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {

    public final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text) {
        return movieRepository.searchMovies(text);
    }
}
