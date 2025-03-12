package net.ibandorta.projects.GestorPeliculas.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.ibandorta.projects.GestorPeliculas.util.MovieGenre;

import java.io.Serializable;
import java.util.List;

public record GetMovie(
        long id,
        String title,
        String director,
        MovieGenre genre,

        @JsonProperty(value = "release_year") int releaseYear,
        List<GetRating> ratings

) implements Serializable {

    public static record GetRating(
                long id,
                int rating,
                String username
    ) implements Serializable{}

}
