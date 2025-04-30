package net.ibandorta.projects.GestorPeliculas.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record SaveUser(
       @Pattern(regexp = "[a-zA-Z0-9__]{8,255}") @NotBlank String username,
        @Size(max = 255) String name,
        @Size(min=10, max=255) @NotBlank  String password,

        @JsonProperty(value="password_repeated")
        @Size(min=10, max=255) @NotBlank  String passwordRepeated

) implements Serializable {
}
