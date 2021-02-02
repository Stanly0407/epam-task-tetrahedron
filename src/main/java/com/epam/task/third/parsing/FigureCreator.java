package com.epam.task.third.parsing;


import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FigureCreator {

    private static final String SEPARATOR = "[\\s]";

    public Tetrahedron createFigure(String data) throws NumberInLineException {

        String[] arrayTetrahedronData = data.split(SEPARATOR);
        List<String> tetrahedronData = new ArrayList<>(Arrays.asList(arrayTetrahedronData));
        try {
            double ribLength = Double.parseDouble(tetrahedronData.get(0));
            List<Point> points = new ArrayList<>();
            int numberParameter = 7;
            for (int i = 1; i < numberParameter; i = i + 2) {
                String parameterX = tetrahedronData.get(i);
                String parameterY = tetrahedronData.get(i + 1);
                double coordinateX = Double.parseDouble(parameterX);
                double coordinateY = Double.parseDouble(parameterY);
                Point point = new Point(coordinateX, coordinateY);
                points.add(point);
            }
            return new Tetrahedron(ribLength, points);
        } catch (NumberFormatException e) {
            throw new NumberInLineException("regex in class DataValidator isn't fully correct", e);
        }
    }
}
