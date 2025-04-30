package net.ibandorta.projects.GestorPeliculas.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import net.ibandorta.projects.GestorPeliculas.util.MovieGenre;

import java.io.Serializable;
import java.time.LocalDateTime;

public record SaveMovie(

        @Size(min= 4, max= 255,message = "{message.size}")
        @NotBlank(message = "{generic.notblank}")
        @Size(min=4 , max=255,message = "{generic.notblank}")
        @NotBlank (message = "{generic.notblank}")
        String director,
        MovieGenre genre,
        @Min(value = 1900, message = "{generic.min}")
        @JsonProperty(value ="release_year") int releaseYear
     //   @JsonProperty("availability_end_time")
    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime availabilityEndTime

) implements Serializable {
}
