package com.epam.task.third.service;

import com.epam.task.third.entities.Tetrahedron;

import java.util.List;


public class TetrahedronSorting  {
    private static final TetrahedronComparator COMPARATOR_BY_ID = new TetrahedronComparator(SortingIndexesEnum.ID);
    private static final TetrahedronComparator COMPARATOR_BY_RIB_LENGTH = new TetrahedronComparator(SortingIndexesEnum.RIB_LENGTH);
    private static final TetrahedronComparator COMPARATOR_BY_COORDINATE_X = new TetrahedronComparator(SortingIndexesEnum.POINT_A_COORDINATE_X);
    private static final TetrahedronComparator COMPARATOR_BY_COORDINATE_Y = new TetrahedronComparator(SortingIndexesEnum.POINT_A_COORDINATE_Y);

    public void sortById(List<Tetrahedron> tetrahedrons) {
          tetrahedrons.sort(COMPARATOR_BY_ID);
    }

    public void sortByRibLength(List<Tetrahedron> tetrahedrons) {
         tetrahedrons.sort(COMPARATOR_BY_RIB_LENGTH);
    }

    public void sortByCoordinateX(List<Tetrahedron> tetrahedrons) {
        tetrahedrons.sort(COMPARATOR_BY_COORDINATE_X);
    }

    public void  sortByCoordinateY(List<Tetrahedron> tetrahedrons) {
        tetrahedrons.sort(COMPARATOR_BY_COORDINATE_Y);
    }

}
