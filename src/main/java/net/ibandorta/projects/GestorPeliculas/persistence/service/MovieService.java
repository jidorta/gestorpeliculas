package net.ibandorta.projects.GestorPeliculas.persistence.service;

import net.ibandorta.projects.GestorPeliculas.persistence.entity.Movie;
import net.ibandorta.projects.GestorPeliculas.util.MovieGenre;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    List<Movie> findAllByTitle(String title);

    List<Movie> findAllByGenre(MovieGenre genre);

    List<Movie> findAllByGenreAndTitle(MovieGenre genre, String title);

    Movie findOneById(Long id);

    Movie createOne(Movie movie);

    Movie updateOneById(Long id, Movie movie);

    void deleteOneById(Long id);
}
