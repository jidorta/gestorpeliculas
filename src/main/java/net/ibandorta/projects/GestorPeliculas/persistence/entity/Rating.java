package net.ibandorta.projects.GestorPeliculas.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

@Entity
public  class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="movie_id",nullable = false)
    private Long movieId;

    @Column(name="user_id", nullable = false)
    @JoinColumn(name= "user_id")
    private Long userId;

    @Check(constraints = "rating >=0 and rating <=5")
    @Column(nullable = false)
    private int rating;

    @ManyToOne
    @JoinColumn(name ="movie_id", insertable = false, updatable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
