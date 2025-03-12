package net.ibandorta.projects.GestorPeliculas.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.ibandorta.projects.GestorPeliculas.util.MovieGenre;

import java.io.Serializable;

public record SaveMovie(
                String title,
                String director,
                MovieGenre genre,
                @JsonProperty(value ="release_year") int releaseYear
) implements Serializable {
}
