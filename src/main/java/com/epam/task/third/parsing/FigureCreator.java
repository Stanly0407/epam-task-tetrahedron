package com.epam.task.third.parsing;


import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FigureCreator {

    private static final String SEPARATOR = "[\\s+]";
    private static final int ELEMENTS_IN_LINE = 7;

    public Tetrahedron createFigure(String data) throws ValidateProcessException {
        String[] arrayTetrahedronData = data.split(SEPARATOR);
        List<String> tetrahedronData = new ArrayList<>(Arrays.asList(arrayTetrahedronData));
        try {
            double ribLength = Double.parseDouble(tetrahedronData.get(0));
            List<Point> points = createPoints(tetrahedronData);
            Point pointA = points.get(0);
            Point pointB = points.get(1);
            Point pointC = points.get(2);
            return new Tetrahedron(ribLength, pointA, pointB, pointC);
        } catch (NumberFormatException e) {
            throw new ValidateProcessException("regex in class DataValidator isn't fully correct", e);
        }
    }

    public List<Point> createPoints(List<String> tetrahedronData) {
        List<Point> points = new ArrayList<>();
        for (int i = 1; i < ELEMENTS_IN_LINE; i = i + 2) {
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
