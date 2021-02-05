package com.epam.task.third.repository;

import com.epam.task.third.entities.Tetrahedron;

public class SearchingByIdSpecification implements TetrahedronSpecification {

    private int desiredId;

    public SearchingByIdSpecification(int desiredRibLength) {
        this.desiredId = desiredRibLength;
    }

    @Override
    public boolean isConformsTo(Tetrahedron tetrahedron) {
        int tetrahedronId = tetrahedron.getId();
        return tetrahedronId == desiredId;
    }
}



