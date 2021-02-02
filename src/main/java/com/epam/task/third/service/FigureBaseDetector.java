package com.epam.task.third.service;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;

import java.util.List;

public class FigureBaseDetector {

    public double getDistanceBetweenPoints(Point pointFirst, Point pointSecond) {
        double firstPointCoordinateX = pointFirst.getCoordinateX();
        double firstPointCoordinateY = pointFirst.getCoordinateY();
        double secondPointCoordinateX = pointSecond.getCoordinateX();
        double secondPointCoordinateY = pointSecond.getCoordinateY();

        return Math.sqrt(Math.pow((firstPointCoordinateX - secondPointCoordinateX), 2)
                + (Math.pow((firstPointCoordinateY - secondPointCoordinateY), 2)));
    }


    public boolean isFigureBaseOnCoordinatePlane(Tetrahedron tetrahedron) {
        double epsilon = 0.001;
        double ribLength = tetrahedron.getRibLength();
        List<Point> points = tetrahedron.getPointsOnPlane();
        Point pointA = points.get(0);
        Point pointB = points.get(1);
        Point pointC = points.get(2);
        double distancePointsAB = getDistanceBetweenPoints(pointA, pointB);
        double distancePointsBC = getDistanceBetweenPoints(pointB, pointC);
        double distancePointsCA = getDistanceBetweenPoints(pointC, pointA);

        return (Math.abs(distancePointsAB - ribLength) <= epsilon) &&
                (Math.abs(distancePointsAB - distancePointsBC) <= epsilon) &&
                (Math.abs(distancePointsAB - distancePointsCA) <= epsilon);
    }
}
