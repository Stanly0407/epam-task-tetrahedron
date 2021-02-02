package com.epam.task.third.parsing;

import org.junit.Assert;
import org.junit.Test;

public class DataValidatorTest {

    private DataValidator dataValidator = new DataValidator();

    private static final String RIGHT_LINE = "5.0 1.0 2.0 6.0 7.0 9.0 2.0";
    private static final String WRONG_LINE = "g 1.0 c 6.0p 7.0 9.0 2.=,0";

    @Test
    public void validateLineShouldReturnTrueIfCorrectLine() {
        boolean methodResult = dataValidator.validateLineContent(RIGHT_LINE);
        Assert.assertTrue(methodResult);
    }

    @Test
    public void validateLineShouldReturnFalseIfIncorrectLine() {
        boolean methodResult = dataValidator.validateLineContent(WRONG_LINE);
        Assert.assertFalse(methodResult);
    }

    @Test
    public void validateIfNotEmptyShouldReturnTrueIfNotEmptyArray() {
        boolean methodResult = dataValidator.validateIfNotEmpty(RIGHT_LINE);
        Assert.assertTrue(methodResult);
    }

    @Test
    public void validateIfNotEmptyShouldReturnFalseIfEmptyArray() {
        String emptyLine = "";
        boolean methodResult = dataValidator.validateIfNotEmpty(emptyLine);
        Assert.assertFalse(methodResult);
    }

}
