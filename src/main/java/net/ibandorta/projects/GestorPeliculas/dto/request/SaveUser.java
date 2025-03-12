package net.ibandorta.projects.GestorPeliculas.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record SaveUser(
        String username,
        String name,
        String password,

        @JsonProperty(value="password_repeated") String passwordRepeated

) implements Serializable {
}
