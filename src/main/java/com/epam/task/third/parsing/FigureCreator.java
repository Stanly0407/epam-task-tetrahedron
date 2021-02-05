package com.epam.task.third.parsing;


import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class FigureCreator {

    private static final String SEPARATOR = "[\\s+]";
    private static final int QUANTITY_INLINE = 7;
    private Random random = new Random(); // for generate Id

    public Tetrahedron createFigure(String data) throws NumberInLineException {
        String[] arrayTetrahedronData = data.split(SEPARATOR);
        List<String> tetrahedronData = new ArrayList<>(Arrays.asList(arrayTetrahedronData));
        try {
            double ribLength = Double.parseDouble(tetrahedronData.get(0));
            List<Point> points = createPoints(tetrahedronData);
            Point pointA = points.get(0);
            Point pointB = points.get(1);
            Point pointC = points.get(2);
            int tetrahedronId = random.nextInt();
            return new Tetrahedron(tetrahedronId, ribLength, pointA, pointB, pointC);
        } catch (NumberFormatException e) {
            throw new NumberInLineException("regex in class DataValidator isn't fully correct", e);
        }
    }

    // write test!
    public List<Point> createPoints(List<String> tetrahedronData) {
        List<Point> points = new ArrayList<>();
        for (int i = 1; i < QUANTITY_INLINE; i = i + 2) {
            String parameterX = tetrahedronData.get(i);
            String parameterY = tetrahedronData.get(i + 1);
            double coordinateX = Double.parseDouble(parameterX);
            double coordinateY = Double.parseDouble(parameterY);
            Point point = new Point(coordinateX, coordinateY);
            points.add(point);
        }
        return points;
    }
}
