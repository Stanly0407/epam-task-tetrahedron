package com.epam.task.third.service;

import com.epam.task.third.entities.Tetrahedron;

import java.util.List;
import java.util.TreeSet;

public class TetrahedronSorting implements FigureSorting {
    private static final TetrahedronComparator COMPARATOR_BY_ID = new TetrahedronComparator(TetrahedronEnum.ID);
    private static final TetrahedronComparator COMPARATOR_BY_RIB_LENGTH = new TetrahedronComparator(TetrahedronEnum.RIB_LENGTH);
    private static final TetrahedronComparator COMPARATOR_BY_COORDINATE_X = new TetrahedronComparator(TetrahedronEnum.POINT_A_COORDINATE_X);
    private static final TetrahedronComparator COMPARATOR_BY_COORDINATE_Y = new TetrahedronComparator(TetrahedronEnum.POINT_A_COORDINATE_Y);

    public TreeSet<Tetrahedron> getTetrahedronsSortedById(List<Tetrahedron> tetrahedrons) {
        TreeSet<Tetrahedron> sortedTetrahedrons = new TreeSet<>(COMPARATOR_BY_ID);
        sortedTetrahedrons.addAll(tetrahedrons);
        return sortedTetrahedrons;
    }

    public TreeSet<Tetrahedron> getTetrahedronsSortedByRibLength(List<Tetrahedron> tetrahedrons) {
        TreeSet<Tetrahedron> sortedTetrahedrons = new TreeSet<>(COMPARATOR_BY_RIB_LENGTH);
        sortedTetrahedrons.addAll(tetrahedrons);
        return sortedTetrahedrons;
    }

    public TreeSet<Tetrahedron> getTetrahedronsSortedByCoordinateX(List<Tetrahedron> tetrahedrons) {
        TreeSet<Tetrahedron> sortedTetrahedrons = new TreeSet<>(COMPARATOR_BY_COORDINATE_X);
        sortedTetrahedrons.addAll(tetrahedrons);
        return sortedTetrahedrons;
    }

    public TreeSet<Tetrahedron> getTetrahedronsSortedByCoordinateY(List<Tetrahedron> tetrahedrons) {
        TreeSet<Tetrahedron> sortedTetrahedrons = new TreeSet<>(COMPARATOR_BY_COORDINATE_Y);
        sortedTetrahedrons.addAll(tetrahedrons);
        return sortedTetrahedrons;
    }

}
