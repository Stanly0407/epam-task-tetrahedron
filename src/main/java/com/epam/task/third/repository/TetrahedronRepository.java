package com.epam.task.third.repository;

import com.epam.task.third.entities.Tetrahedron;

import java.util.List;

public interface TetrahedronRepository {

    void addTetrahedron(Tetrahedron tetrahedron);

    void removeTetrahedron(Tetrahedron tetrahedron);

    void updateTetrahedron(Tetrahedron tetrahedron);

    List<Tetrahedron> query(TetrahedronSpecification specification);
}
