package com.epam.task.third.parsing;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;

public class FigureCreatorTest {

    private FigureCreator figureCreator = new FigureCreator();
    private static final String RIGHT_LINE = "8.0 2.0 2.0 8.0 2.0 5.0 7.5";
    private static final String WRONG_LINE = "g 1.0 c 6.0p 7.0 9.0 2.=,0";

    @Test
    public void shouldCreateFigureFromValidLine() throws ValidateProcessException {
        Tetrahedron createdTetrahedron = figureCreator.createFigure(RIGHT_LINE);
        Point pointA = new Point(2.0, 2.0);
        Point pointB = new Point(8.0, 2.0);
        Point pointC = new Point(5.0, 7.5);
        Tetrahedron expectedTetrahedron = new Tetrahedron(8.0, pointA, pointB, pointC);
        Assert.assertEquals(expectedTetrahedron, createdTetrahedron);
    }

    @Test(expected = ValidateProcessException.class)
    public void createFigureFromInvalidLineShouldTrowsNumberInLineException() throws ValidateProcessException {
        Tetrahedron tetrahedron = figureCreator.createFigure(WRONG_LINE);
    }
}
