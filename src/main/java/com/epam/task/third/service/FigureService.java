package com.epam.task.third.service;

import com.epam.task.third.entities.Tetrahedron;

public interface FigureService {

    double calculateSurfaceArea(Tetrahedron tetrahedron);

    double calculateVolume(Tetrahedron tetrahedron);

    double compareVolumes(Tetrahedron tetrahedron);

    boolean isFigureTetrahedron(Tetrahedron tetrahedron);

    boolean isFigureBaseOnCoordinatePlane(Tetrahedron tetrahedron);

}
