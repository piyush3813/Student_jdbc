package com.bl.validation;

import java.util.regex.Pattern;

public class Validation {
    public static boolean validateName(String name) {
        return Pattern.matches("^[A-Za-z]{3,}$", name);
    }
}
