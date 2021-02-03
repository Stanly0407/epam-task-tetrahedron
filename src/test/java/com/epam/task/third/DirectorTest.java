package com.epam.task.third;

import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.data.PathException;
import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;
import com.epam.task.third.parsing.DataValidator;
import com.epam.task.third.parsing.FigureCreator;
import com.epam.task.third.parsing.NumberInLineException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;


public class DirectorTest {

    private final static String TEST_DATA = "./src/test/resources/input.txt";

    @Test
    public void shouldMakeValidArraysFromFileData() throws DataException, PathException, NumberInLineException, IOException { //not in full

        DataReader dataReader = Mockito.mock(DataReader.class);
        when(dataReader.readDataFromFile(anyString())).thenReturn(Collections.singletonList(TEST_DATA));

        DataValidator dataValidator = Mockito.mock(DataValidator.class);
        when(dataValidator.validateLineContent(anyString())).thenReturn(true);
        when(dataValidator.validateIfNotEmpty(anyString())).thenReturn(true);

        double ribLength = 8.0;
        Point pointA = new Point(2.0, 2.0);
        Point pointB = new Point(8.0, 2.0);
        Point pointC = new Point(5.0, 7.2);
        Tetrahedron tetrahedron = new Tetrahedron(ribLength, pointA, pointB, pointC);
        List<Tetrahedron> expectedResult = new ArrayList<>();
        expectedResult.add(tetrahedron);

        FigureCreator figureCreator = Mockito.mock(FigureCreator.class);
        when(figureCreator.createFigure(anyString())).thenReturn(tetrahedron);

        Director director = new Director(dataReader, dataValidator, figureCreator);

        List<Tetrahedron> actualArrays = new ArrayList<>(director.createFiguresFromFileData(TEST_DATA));

        Assert.assertEquals(expectedResult, actualArrays);
    }
}
