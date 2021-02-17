package com.epam.task.third.repository;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;

public class SearchingByFirstQuadrantSpecification implements TetrahedronSpecification {

    public SearchingByFirstQuadrantSpecification() {
    }

    @Override
    public boolean isConformsTo(Tetrahedron tetrahedron) {
        Point pointA = tetrahedron.getPointA();
        Point pointB = tetrahedron.getPointB();
        Point pointC = tetrahedron.getPointC();
        return pointA.getCoordinateX() >= 0 &&
                pointA.getCoordinateY() >= 0 &&
                pointB.getCoordinateX() >= 0 &&
                pointB.getCoordinateY() >= 0 &&
                pointC.getCoordinateX() >= 0 &&
                pointC.getCoordinateY() >= 0;
    }
}
