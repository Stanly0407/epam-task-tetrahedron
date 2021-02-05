package com.epam.task.third.entities;

import com.epam.task.third.service.TetrahedronService;


public class TetrahedronObserver implements Observer {

    private TetrahedronService calculator = new TetrahedronService();
    private ParametersRegistrar registrar = ParametersRegistrar.getRegistrar();

    @Override
    public void update(Tetrahedron tetrahedron) {
        double newSurfaceArea = calculator.calculateSurfaceArea(tetrahedron);
        double newVolume = calculator.calculateVolume(tetrahedron);
        TetrahedronParameters newParameters = new TetrahedronParameters(newSurfaceArea, newVolume);
        registrar.updateParameters(tetrahedron.getId(), newParameters);
    }
}
