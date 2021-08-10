package com.epam.task.third.repository;

import com.epam.task.third.entities.Tetrahedron;


public interface TetrahedronSpecification {

    boolean isConformsTo(Tetrahedron tetrahedron);

}