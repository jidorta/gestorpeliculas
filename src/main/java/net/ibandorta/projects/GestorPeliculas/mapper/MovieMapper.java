package net.ibandorta.projects.GestorPeliculas.mapper;

import net.ibandorta.projects.GestorPeliculas.dto.request.SaveMovie;
import net.ibandorta.projects.GestorPeliculas.dto.response.GetMovie;

import net.ibandorta.projects.GestorPeliculas.persistence.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MovieMapper {
    private static final Logger log = LoggerFactory.getLogger(MovieMapper.class);

    public static GetMovie toGetDto(Movie entity){
        if (entity == null) return null;

        return  new GetMovie(
                entity.getId(),
                entity.getTitle(),
                entity.getDirector(),
                entity.getGenre(),
                entity.getReleaseYear(),
                null);

    }


    public static List<GetMovie> toGetDtoList(List<Movie> entities){
        if (entities == null) return null;

        return entities.stream()
                .map(MovieMapper::toGetDto)
                .toList();
    }

    public static Movie toEntity(SaveMovie saveDto){
        if(saveDto == null)return null;

        Movie newMovie = new Movie();
        newMovie.setTitle(saveDto.title());
        newMovie.setDirector(saveDto.director());
        newMovie.setReleaseYear(saveDto.releaseYear());
        newMovie.setGenre(saveDto.genre());
        return newMovie;
    }


    public static void updateEntity(Movie oldMovie, SaveMovie saveDto) {
        if (oldMovie == null || saveDto == null) return;

        oldMovie.setGenre(saveDto.genre());
        oldMovie.setReleaseYear(saveDto.releaseYear());
        oldMovie.setTitle(saveDto.title());
        oldMovie.setDirector(saveDto.director());
    }
}
