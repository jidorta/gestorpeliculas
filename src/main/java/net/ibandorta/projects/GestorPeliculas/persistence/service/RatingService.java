package net.ibandorta.projects.GestorPeliculas.persistence.service;

import net.ibandorta.projects.GestorPeliculas.persistence.entity.Rating;

import java.util.List;

public interface RatingService {

    List<Rating> findAll();

    List<Rating> findAllByMovieId(Long movieId);

    List<Rating> findAllByUsername(String username);

    Rating findOneById(Long id);

    Rating createOne(Rating rating);

    Rating updateOneById(Long id, Rating rating);

    void deleteOneById(Long id);
    

}
