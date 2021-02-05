package com.epam.task.third.repository;

import com.epam.task.third.entities.Tetrahedron;


public interface TetrahedronSpecification {

    double DELTA = 0.01;

    boolean isConformsTo(Tetrahedron tetrahedron);

}