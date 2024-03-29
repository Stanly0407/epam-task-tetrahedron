package com.epam.task.third.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    private final static String TEST_DATA = "./src/test/resources/input.txt";
    private final static String WRONG_PATH = "./src/input.txt";
    private DataReader dataReader = new DataReader();

    @Test
    public void readDataTestShouldReturnStringsListFromLines () throws DataException, PathException {
        List<String> expectedLines = new ArrayList<>(Arrays.asList("6.0 2.0 2.0 8.0 2.0 5.0 7.2", "", "5.0 1.0 2.0 6.0 7.0 9.0 2.0"));
        List<String> lines = new ArrayList<>(dataReader.readDataFromFile(TEST_DATA));
        Assert.assertEquals(expectedLines, lines);
    }

    @Test (expected = PathException.class)
    public void readDataTestShouldThrowsPathException() throws DataException, PathException {
        List<String> lines = new ArrayList<>(dataReader.readDataFromFile(WRONG_PATH));
    }
}
