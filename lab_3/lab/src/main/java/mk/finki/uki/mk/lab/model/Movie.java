package mk.finki.uki.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    private String title;
    @Getter
    private String summary;
    @Getter
    private double rating;;
    @ManyToOne
    private Production production;

    public Movie(String title, String summary, double rating, Production production) {
        this.title = title;
        this.summary = summary;
        this.rating = rating;
        this.production=production;
    }

    public Movie() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
