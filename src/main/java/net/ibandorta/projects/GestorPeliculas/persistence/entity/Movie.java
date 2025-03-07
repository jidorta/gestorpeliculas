package net.ibandorta.projects.GestorPeliculas.persistence.entity;

import jakarta.persistence.*;
import net.ibandorta.projects.GestorPeliculas.util.MovieGenre;

import java.util.List;


@Entity
public class Movie {

    @Id @GeneratedValue (strategy =GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String director;

     @Enumerated(EnumType.STRING)
    private MovieGenre genre;

    @Column(name = "release_year")
    private int releaseYear;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "movie" )
    private List<Rating> ratings;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }
}
