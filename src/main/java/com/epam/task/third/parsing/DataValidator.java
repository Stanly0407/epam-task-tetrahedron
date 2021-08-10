package com.epam.task.third.parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    private static final String DOUBLES_IN_LINE_PATTERN = "(\\d+(\\.\\d+)[\\s+]){6}(\\d+(\\.\\d+))";

    public boolean validateLineContent(String line) {
        Pattern linePattern = Pattern.compile(DOUBLES_IN_LINE_PATTERN);
        Matcher matcher = linePattern.matcher(line);
        return matcher.matches();
    }
}