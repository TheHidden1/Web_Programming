package mk.finki.uki.mk.lab.model;

import lombok.Data;
import lombok.Getter;

@Data
public class Movie {
    @Getter
    private String title;
    @Getter
    private String summary;
    @Getter
    private double rating;
    @Getter
    private Long id;
    private Production production;

    public Movie(String title, String summary, double rating, Production production) {
        this.title = title;
        this.summary = summary;
        this.rating = rating;
        this.id = (long) (Math.random()*1000);
        this.production=production;
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
