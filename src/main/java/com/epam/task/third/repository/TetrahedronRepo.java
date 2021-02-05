package com.epam.task.third.repository;

import com.epam.task.third.entities.Tetrahedron;

import java.util.List;

public interface TetrahedronRepo {

   // Tetrahedron getTetrahedron(Long id);

    void addTetrahedron(Tetrahedron tetrahedron);

    void removeTetrahedron(Tetrahedron tetrahedron);

    void updateTetrahedron(Tetrahedron tetrahedron);

    List query(TetrahedronSpecificationSearchingOne specification);

   // List<Tetrahedron> getAllTetrahedrons();

}
