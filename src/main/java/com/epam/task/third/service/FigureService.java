package com.epam.task.third.service;

import com.epam.task.third.entities.Tetrahedron;

public interface FigureService {

    double calculateSurfaceArea(Tetrahedron tetrahedron);

    double calculateFigureVolume(Tetrahedron tetrahedron);

    double compareVolumesAfterSection(Tetrahedron tetrahedron);

    boolean isFigureDefinedShape(Tetrahedron tetrahedron);

    boolean isFigureBaseOnCoordinatePlane(Tetrahedron tetrahedron);

}
