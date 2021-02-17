package com.epam.task.third.repository;

import com.epam.task.third.entities.Tetrahedron;

public class SearchingByRibLengthSpecification implements TetrahedronSpecification {

    private static final double DELTA = 0.01;
    private double desiredRibLength;

    public SearchingByRibLengthSpecification(double desiredRibLength) {
        this.desiredRibLength = desiredRibLength;
    }

    @Override
    public boolean isConformsTo(Tetrahedron tetrahedron) {
        double ribLength = tetrahedron.getRibLength();
        return Math.abs(ribLength - desiredRibLength) < DELTA;
    }
}
