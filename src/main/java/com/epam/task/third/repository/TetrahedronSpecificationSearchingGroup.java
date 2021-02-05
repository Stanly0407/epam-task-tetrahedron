package com.epam.task.third.repository;

import com.epam.task.third.entities.Tetrahedron;

import java.util.List;


public interface TetrahedronSpecificationSearchingGroup {

    List<Tetrahedron> search(Tetrahedron tetrahedron);

}
