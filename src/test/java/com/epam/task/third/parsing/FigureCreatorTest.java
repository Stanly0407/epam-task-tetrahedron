package com.epam.task.third.parsing;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;

public class FigureCreatorTest {

    private FigureCreator figureCreator = new FigureCreator();
    private static final String TESTED_LINE = "8.0 2.0 2.0 8.0 2.0 5.0 7.5";

    @Test
    public void shouldCreateFigureFromValidLine() {
        Point pointA = new Point(2.0, 2.0);
        Point pointB = new Point(8.0, 2.0);
        Point pointC = new Point(5.0, 7.5);
        Tetrahedron expectedTetrahedron = new Tetrahedron(8.0, pointA, pointB, pointC);
        Tetrahedron createdTetrahedron = figureCreator.createFigure(TESTED_LINE);
        Assert.assertEquals(expectedTetrahedron, createdTetrahedron);
    }
}
