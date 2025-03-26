package net.ibandorta.projects.GestorPeliculas.mapper;

import net.ibandorta.projects.GestorPeliculas.dto.response.GetMovie;
import net.ibandorta.projects.GestorPeliculas.dto.response.GetUser;
import net.ibandorta.projects.GestorPeliculas.persistence.entity.Rating;

import java.util.List;

public class RatingMapper {

    public static GetMovie.GetRating toGetMovieRatingDto(Rating entity){
        if(entity == null) return null;

        String username = entity.getUser() != null
                ? entity.getUser().getUsername()
                : null;

        return new GetMovie.GetRating(
                entity.getId(),
                entity.getRating(),
                username
        );
    }

    public static GetUser.GetRating toGetUserRatingDto(Rating entity){
        if(entity == null) return null;

        String movieTitle = entity.getMovie() != null
                ? entity.getMovie().getTitle()
                : null;

        return new GetUser.GetRating(
                    entity.getId(),
                    movieTitle,
                entity.getMovieId(),
                entity.getRating()


        );
    }

    public static List<GetMovie.GetRating> toGetMovieRatingDtoList(List<Rating> entities){
        if(entities == null)return null;

        return entities.stream()
                .map(RatingMapper::toGetMovieRatingDto)
                .toList();
    }



    public static List<GetUser.GetRating> toGetUserRatingDtoList(List<Rating> entities){
        if(entities == null)return null;

        return entities.stream()
                .map(RatingMapper::toGetUserRatingDto)
                .toList();
    }
}
