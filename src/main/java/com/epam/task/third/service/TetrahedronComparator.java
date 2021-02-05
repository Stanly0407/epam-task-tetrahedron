package com.epam.task.third.service;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;

import java.util.Comparator;

public class TetrahedronComparator implements Comparator<Tetrahedron> {
    private static final double DELTA = 0.01;
    private TetrahedronEnum sortingIndex;

    public TetrahedronComparator(TetrahedronEnum sortingIndex) {
        this.sortingIndex = sortingIndex;
    }

    public TetrahedronEnum getSortingIndex() {
        return sortingIndex;
    }

    public final void setSortingIndex(TetrahedronEnum sortingIndex) {
        this.sortingIndex = sortingIndex;
    }

    @Override
    public int compare(Tetrahedron first, Tetrahedron second) {
        Point firstPointA = first.getPointA();
        Point secondPointA = second.getPointA();
        double firstCoordinateX = firstPointA.getCoordinateX();
        double secondCoordinateX = secondPointA.getCoordinateX();
        double firstCoordinateY = firstPointA.getCoordinateY();
        double secondCoordinateY = secondPointA.getCoordinateY();
        switch (sortingIndex) {
            case ID:
                return first.getId() - second.getId();
            case RIB_LENGTH:
                return Double.compare(Math.abs(first.getRibLength() - second.getRibLength()), DELTA);
            case POINT_A_COORDINATE_X:
                return Double.compare(Math.abs(firstCoordinateX - secondCoordinateX), DELTA);
            case POINT_A_COORDINATE_Y:
                return Double.compare(Math.abs(firstCoordinateY - secondCoordinateY), DELTA);
            default:
                throw new EnumConstantNotPresentException(TetrahedronEnum.class, sortingIndex.name());
        }
    }
}
