package com.epam.task.third.entities;

import com.epam.task.third.service.TetrahedronService;

import java.util.HashMap;
import java.util.Map;

public class TetrahedronObserver implements Observer {

    private TetrahedronObservable tetrahedronObservable;

    private TetrahedronService calculator = new TetrahedronService();
    private Map<Integer, Parameters> parametersMap = new HashMap<>(); //RENAME
    private Parameters parameters = Parameters.getParameters();

    @Override
    public void update(Tetrahedron tetrahedron) {
        double newSurfaceArea = calculator.calculateSurfaceArea(tetrahedron);
        double newVolume = calculator.calculateVolume(tetrahedron);
        parameters.setSurfaceArea(newSurfaceArea);
        parameters.setVolume(newVolume);
        parametersMap.put(tetrahedron.getId(), parameters);
    }
}
