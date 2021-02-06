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
        int compareResult;
        switch (sortingIndex) {
            case ID:
                compareResult = first.getId() - second.getId();
                break;
            case RIB_LENGTH:
                compareResult = Double.compare(Math.abs(first.getRibLength() - second.getRibLength()), DELTA);
                break;
            case POINT_A_COORDINATE_X:
                compareResult = Double.compare(Math.abs(firstCoordinateX - secondCoordinateX), DELTA);
                break;
            case POINT_A_COORDINATE_Y:
                compareResult = Double.compare(Math.abs(firstCoordinateY - secondCoordinateY), DELTA);
                break;
            default:
                throw new EnumConstantNotPresentException(TetrahedronEnum.class, sortingIndex.name());
        }
        return compareResult;
    }
}
