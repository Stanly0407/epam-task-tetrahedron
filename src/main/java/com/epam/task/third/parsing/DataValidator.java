package com.epam.task.third.parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    public boolean validateLineContent(String line) {
        String onlyDigitsAndSpaces = "^([\\d -.]\\s*)+$"; //Первая цифра д.б. положительной.
        Pattern linePattern = Pattern.compile(onlyDigitsAndSpaces);
        Matcher matcher = linePattern.matcher(line);
        return matcher.matches();
    }

    public boolean validateIfNotEmpty(String line) {
        return !line.isEmpty();
    }

}
