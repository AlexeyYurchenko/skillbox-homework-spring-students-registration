package com.example.studentsregistration.util;

import java.util.regex.Pattern;

public class PersonValidator {
    private static final Pattern firstNamePattern =
            Pattern.compile("^[А-ЯЁа-яё '-]+$");
    private static final Pattern lastNamePattern =
            Pattern.compile("^[А-ЯЁа-яё '-]+$");
    private static final Pattern agePattern =
            Pattern.compile("^([1-9]?\\d|100)$");

    public static boolean isfirstName(String input) {
        return firstNamePattern.matcher(input).matches();
    }

    public static boolean islastName(String input) {
        return lastNamePattern.matcher(input).matches();
    }

    public static boolean isAge(String input) {
        return agePattern.matcher(input).matches();
    }
}