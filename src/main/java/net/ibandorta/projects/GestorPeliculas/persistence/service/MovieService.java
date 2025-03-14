package net.ibandorta.projects.GestorPeliculas.persistence.service;

import net.ibandorta.projects.GestorPeliculas.dto.request.SaveMovie;
import net.ibandorta.projects.GestorPeliculas.dto.response.GetMovie;
import net.ibandorta.projects.GestorPeliculas.persistence.entity.Movie;
import net.ibandorta.projects.GestorPeliculas.util.MovieGenre;

import java.util.List;

public interface MovieService {

    List<GetMovie> findAll();

    List<GetMovie> findAllByTitle(String title);

    List<GetMovie> findAllByGenre(MovieGenre genre);

    List<GetMovie> findAllByGenreAndTitle(MovieGenre genre, String title);

    GetMovie findOneById(Long id);

    GetMovie createOne(SaveMovie saveDto);

    GetMovie updateOneById(Long id, SaveMovie saveDto);

    void deleteOneById(Long id);
}
