package net.ibandorta.projects.GestorPeliculas.persistence.repository;

import net.ibandorta.projects.GestorPeliculas.persistence.entity.Movie;
import net.ibandorta.projects.GestorPeliculas.util.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieCrudRepository extends JpaRepository<Movie,Long> {


    List<Movie> findByTitleContaining(String title);

    List<Movie> findByGenre(MovieGenre genre);

    List<Movie> findByGeneAndTitleContaining(MovieGenre genre,String title);

}
