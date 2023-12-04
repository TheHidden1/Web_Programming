package mk.finki.uki.mk.lab.service.impl;

import mk.finki.uki.mk.lab.model.Movie;
import mk.finki.uki.mk.lab.model.Production;
import mk.finki.uki.mk.lab.model.exceptions.ProductionNotFoundException;
import mk.finki.uki.mk.lab.repository.jpa.MovieRepository;
import mk.finki.uki.mk.lab.repository.jpa.ProductionRepository;
import mk.finki.uki.mk.lab.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private final ProductionRepository productionRepository;
    public final MovieRepository movieRepository;

    public MovieServiceImpl(ProductionRepository productionRepository, MovieRepository movieRepository) {
        this.productionRepository = productionRepository;
        this.movieRepository = movieRepository;
    }


    @Override
    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text) {
        return movieRepository.findAllByTitleLike(text);
    }

    @Override
    public List<Movie> searchMoviesByRating(double rating) {
        return this.movieRepository.findAllByRating(rating);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return this.movieRepository.findById(id);
    }

    @Override
    public Optional<Movie> saveMovie(String movieTitle, String summary, double rating, Long productionId) {
        Production production = this.productionRepository.findById(productionId)
                .orElseThrow(() -> new ProductionNotFoundException(productionId));
        Movie movie= new Movie(movieTitle, summary,rating,production);
        return Optional.of(this.movieRepository.save(movie));
    }

    @Override
    public void deleteById(Long id) {
        this.movieRepository.deleteById(id);
    }
}
