package net.ibandorta.projects.GestorPeliculas.persistence.service.validator;

import net.ibandorta.projects.GestorPeliculas.exception.InvalidPasswordException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


public class PasswordValidator {

    public static void validatePassword(String password, String passwordRepeated) {
        if (!StringUtils.hasText(password) || !StringUtils.hasText(passwordRepeated)) {
            throw new IllegalArgumentException("Passwords must contain data");
        }

        if (!password.equals(passwordRepeated)) {
            throw new InvalidPasswordException(password, passwordRepeated, "Passwords do not match", null);
        }

        if (!containsNumber(password)) {
            throw new InvalidPasswordException(password, "Password Repeat", null);
        }

        if (!containsUpperCase(password)) {
            throw new InvalidPasswordException(password, "Password must contain at least one uppercase letter", null);
        }

        if (!containsLowerCase(password)) {
            throw new InvalidPasswordException(password, "Password must contain at least one lowerCase letter", null);
        }

        if (!containsSpecialCharacter(password)) {
            throw new InvalidPasswordException(password, "Password must contain at least one special caracter", null);
        }

    }

    private static boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }


    private static boolean containsSpecialCharacter(String password) {

        return password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?].*");
    }

    private static boolean containsLowerCase(String password) {

        return password.matches(".*[a-z].*");
    }

    private static boolean containsNumber(String password) {

        return password.matches(".*\\d.*");
    }
}
