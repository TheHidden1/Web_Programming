package mk.finki.uki.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.uki.mk.lab.model.Movie;
import mk.finki.uki.mk.lab.service.MovieService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "MovieListServlet", urlPatterns = "")
public class MovieListServlet extends HttpServlet {
    public final MovieService movieService;
    public final SpringTemplateEngine springTemplateEngine;

    public MovieListServlet(MovieService movieService, SpringTemplateEngine springTemplateEngine) {
        this.movieService = movieService;
        this.springTemplateEngine = springTemplateEngine;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> movies= movieService.listAll();

        String text= req.getParameter("text");
      //  double rating= Double.parseDouble(req.getParameter("rating"));

        // Filter
//        movies=movieService.searchMovies(text);
//        movies = movies.stream().filter(m ->m.getRating()>=rating).collect(Collectors.toList());

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);


        WebContext context= new WebContext(webExchange);
        context.setVariable("movies", movies);

        springTemplateEngine.process("listMovies.html", context, resp.getWriter());

    }
}
