package com.epam.task.third.parsing;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FigureCreatorTest {

    private FigureCreator figureCreator = new FigureCreator();
    private static final String RIGHT_LINE = "8.0 2.0 2.0 8.0 2.0 5.0 7.5";
    private static final String WRONG_LINE = "g 1.0 c 6.0p 7.0 9.0 2.=,0";

    @Test
    public void shouldCreateFigureFromValidLine() throws NumberInLineException {
        Tetrahedron createdTetrahedron = figureCreator.createFigure(RIGHT_LINE);
        List<Point> points = new ArrayList<>();
        Point pointA = new Point(2.0, 2.0);
        points.add(pointA);
        Point pointB = new Point(8.0, 2.0);
        points.add(pointB);
        Point pointC = new Point(5.0, 7.5);
        points.add(pointC);
        Tetrahedron expectedTetrahedron = new Tetrahedron(8.0, points);
        Assert.assertEquals(expectedTetrahedron, createdTetrahedron);
    }

    @Test(expected = NumberInLineException.class)
    public void createFigureFromInvalidLineShouldTrowsNumberInLineException() throws NumberInLineException {
        Tetrahedron tetrahedron = figureCreator.createFigure(WRONG_LINE);
    }
}
