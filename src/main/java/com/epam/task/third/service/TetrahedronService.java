package com.epam.task.third.service;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;
import org.apache.log4j.Logger;

public class TetrahedronService {

    private static final Logger LOGGER = Logger.getLogger(TetrahedronService.class);

    private static final double DELTA = 0.01;
    private static final double VOLUME_FORMULA_PROPORTION = 1.0 / 12.0;
    private static final double ROOT_OF_THREE = Math.sqrt(3);
    private static final double ROOT_OF_TWO = Math.sqrt(2);
    private static final double SECOND_DEGREE = 2;
    private static final double THIRD_DEGREE = 3;

    public double calculateSurfaceArea(Tetrahedron tetrahedron) {
        double ribLength = tetrahedron.getRibLength();
        return ROOT_OF_THREE * Math.pow(ribLength, SECOND_DEGREE);
    }

    public double calculateVolume(Tetrahedron tetrahedron) {
        double ribLength = tetrahedron.getRibLength();
        return VOLUME_FORMULA_PROPORTION * Math.pow(ribLength, THIRD_DEGREE) * ROOT_OF_TWO;
    }

    public double proportionPartVolumes(Tetrahedron tetrahedron) {
        double ribLengthOfSmallTetrahedron = getDistanceBetweenTwoPoints(tetrahedron);
        LOGGER.debug("method getDistanceBetweenTwoPoints worked");
        Tetrahedron smallTetrahedron = new Tetrahedron(ribLengthOfSmallTetrahedron);
        double volumeOfMainTetrahedron = calculateVolume(tetrahedron);
        double volumeOfSmallTetrahedron = calculateVolume(smallTetrahedron);
        return volumeOfSmallTetrahedron / volumeOfMainTetrahedron;
    }

    public boolean isFigureTetrahedron(Tetrahedron tetrahedron) {
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

    public double getDistanceBetweenTwoPoints(Tetrahedron tetrahedron) {
        Point pointA = tetrahedron.getPointA();
        Point pointB = tetrahedron.getPointB();
        return getDistanceBetweenTwoPoints(pointA, pointB);
    }

    public double getDistanceBetweenTwoPoints(Point pointA, Point pointB) {
        double firstPointCoordinateX = pointA.getCoordinateX();
        double firstPointCoordinateY = pointA.getCoordinateY();
        double secondPointCoordinateX = pointB.getCoordinateX();
        double secondPointCoordinateY = pointB.getCoordinateY();

        return Math.sqrt(Math.pow((firstPointCoordinateX - secondPointCoordinateX), SECOND_DEGREE)
                + (Math.pow((firstPointCoordinateY - secondPointCoordinateY), SECOND_DEGREE)));
    }
}
