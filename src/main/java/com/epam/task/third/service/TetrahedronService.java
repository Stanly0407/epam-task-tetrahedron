package com.epam.task.third.service;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;
import org.apache.log4j.Logger;

import java.util.List;

public class TetrahedronService implements FigureService {

    private static final Logger LOGGER = Logger.getLogger(TetrahedronService.class);

    private static final double DELTA = 0.01;

    public double calculateSurfaceArea(Tetrahedron tetrahedron) {
        double ribLength = tetrahedron.getRibLength();
        return Math.sqrt(3) * Math.pow(ribLength, 2);
    }

    public double calculateFigureVolume(Tetrahedron tetrahedron) {
        double ribLength = tetrahedron.getRibLength();
        return (1.0 / 12.0) * Math.pow(ribLength, 3) * Math.sqrt(2);
    }

    public double compareVolumesAfterSection(Tetrahedron tetrahedron) {
        double ribLengthOfSmallTetrahedron = getDistanceBetweenTwoPoints(tetrahedron);
        LOGGER.info("getDistanceBetweenTwoPoints worked");
        Tetrahedron smallTetrahedron = new Tetrahedron(ribLengthOfSmallTetrahedron);
        double volumeOfMainTetrahedron = calculateFigureVolume(tetrahedron);
        double volumeOfSmallTetrahedron = calculateFigureVolume(smallTetrahedron);
        return volumeOfSmallTetrahedron / volumeOfMainTetrahedron;
    }

    public boolean isFigureDefinedShape(Tetrahedron tetrahedron) {
        Point pointA = tetrahedron.getPointA();
        Point pointB = tetrahedron.getPointB();
        Point pointC = tetrahedron.getPointC();
        double distanceAB = getDistanceBetweenTwoPoints(pointA, pointB);
        double distanceBC = getDistanceBetweenTwoPoints(pointB, pointC);
        double distanceCA = getDistanceBetweenTwoPoints(pointC, pointA);
        double ribLength = tetrahedron.getRibLength();

        return (Math.abs(ribLength - distanceAB) > DELTA) &&
                (Math.abs(ribLength - distanceBC) > DELTA) &&
                (Math.abs(ribLength - distanceCA) > DELTA) &&
                (Math.abs(distanceAB - distanceBC) < DELTA) &&
                (Math.abs(distanceAB - distanceCA) < DELTA);
    }

    public boolean isFigureBaseOnCoordinatePlane(Tetrahedron tetrahedron) {
        double ribLength = tetrahedron.getRibLength();
        double distancePointsAB = getDistanceBetweenTwoPoints(tetrahedron);
        return (Math.abs(distancePointsAB - ribLength) < DELTA);
    }

    public double getDistanceBetweenTwoPoints(Tetrahedron tetrahedron) { //for validated shape of figure
        Point pointA = tetrahedron.getPointA();
        Point pointB = tetrahedron.getPointB();
        return getDistanceBetweenTwoPoints(pointA, pointB);
    }

    public double getDistanceBetweenTwoPoints(Point pointA, Point pointB) {
        double firstPointCoordinateX = pointA.getCoordinateX();
        double firstPointCoordinateY = pointA.getCoordinateY();
        double secondPointCoordinateX = pointB.getCoordinateX();
        double secondPointCoordinateY = pointB.getCoordinateY();

        return Math.sqrt(Math.pow((firstPointCoordinateX - secondPointCoordinateX), 2)
                + (Math.pow((firstPointCoordinateY - secondPointCoordinateY), 2)));
    }
}
