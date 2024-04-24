package mx.edu.extra.utils;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public class Utils {
    public static String getValidationErrorMessages(Set<ConstraintViolation<?>> errors) {
        String messages = "";
        for (ConstraintViolation<?> error: errors) {
            messages += error.getMessage() + ',';
        }
        return messages.substring(0, messages.length() - 1);
    }
}
