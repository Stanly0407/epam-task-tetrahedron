package com.epam.task.third.entities;

import com.epam.task.third.service.TetrahedronService;

import java.util.HashMap;
import java.util.Map;


public class TetrahedronObserver implements Observer {

    private TetrahedronService calculator = new TetrahedronService();
    private Map<Integer, Parameters> parameterRegistrar = new HashMap<>();

    private TetrahedronObserver() {
    }

    private static class SingletonHolder {
        private static final TetrahedronObserver REGISTRAR = new TetrahedronObserver();
    }

    public static TetrahedronObserver getRegistrar() {
        return TetrahedronObserver.SingletonHolder.REGISTRAR;
    }

    @Override
    public void updateParameters(Tetrahedron tetrahedron) {
        double newSurfaceArea = calculator.calculateSurfaceArea(tetrahedron);
        double newVolume = calculator.calculateVolume(tetrahedron);
        Parameters newParameters = new Parameters(newSurfaceArea, newVolume);
        parameterRegistrar.put(tetrahedron.getId(), newParameters);
    }


    public Map<Integer, Parameters> getParameterRegistrar() {
        return parameterRegistrar;
    }

    public void setParameterRegistrar(Map<Integer, Parameters> parameterRegistrar) {
        this.parameterRegistrar = parameterRegistrar;
    }
}
