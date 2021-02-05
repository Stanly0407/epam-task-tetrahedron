package com.epam.task.third.service;

import com.epam.task.third.entities.Tetrahedron;

import java.util.List;
import java.util.TreeSet;

public interface FigureSorting {

    TreeSet<Tetrahedron> getTetrahedronsSortedById(List<Tetrahedron> tetrahedrons);

    TreeSet<Tetrahedron> getTetrahedronsSortedByRibLength(List<Tetrahedron> tetrahedrons);

    TreeSet<Tetrahedron> getTetrahedronsSortedByCoordinateX(List<Tetrahedron> tetrahedrons);

    TreeSet<Tetrahedron> getTetrahedronsSortedByCoordinateY(List<Tetrahedron> tetrahedrons);

}
