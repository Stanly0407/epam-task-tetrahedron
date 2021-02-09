package com.epam.task.third.service;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;

import java.util.Comparator;

public class TetrahedronComparator implements Comparator<Tetrahedron> {
    private SortingIndexesEnum sortingIndex;

    public TetrahedronComparator(SortingIndexesEnum sortingIndex) {
        this.sortingIndex = sortingIndex;
    }

    public SortingIndexesEnum getSortingIndex() {
        return sortingIndex;
    }

    public final void setSortingIndex(SortingIndexesEnum sortingIndex) {
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
                compareResult = Integer.compare(first.getId(), second.getId());
                break;
            case RIB_LENGTH:
                compareResult = Double.compare(first.getRibLength(), second.getRibLength());
                break;
            case POINT_A_COORDINATE_X:
                compareResult = Double.compare(firstCoordinateX, secondCoordinateX);
                break;
            case POINT_A_COORDINATE_Y:
                compareResult = Double.compare(firstCoordinateY, secondCoordinateY);
                break;
            default:
                throw new EnumConstantNotPresentException(SortingIndexesEnum.class, sortingIndex.name());
        }
        return compareResult;
    }
}
