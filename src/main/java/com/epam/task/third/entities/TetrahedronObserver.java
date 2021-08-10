package com.epam.task.third.entities;

import com.epam.task.third.service.TetrahedronService;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class TetrahedronObserver implements Observer {

    private static final Logger LOGGER = Logger.getLogger(TetrahedronObserver.class);

    private TetrahedronService calculator = new TetrahedronService();
    private Map<Integer, Parameters> parameterRegistrar = new HashMap<>();

    private TetrahedronObserver() {
    }

    private static class SingletonHolder {
        private static final TetrahedronObserver REGISTRAR = new TetrahedronObserver();
    }

    public static TetrahedronObserver getRegistrar() {
        LOGGER.debug("Object Registrar (Singleton) was received");
        return TetrahedronObserver.SingletonHolder.REGISTRAR;
    }

    @Override
    public void updateParameters(Tetrahedron tetrahedron) {
        LOGGER.debug("Observer was notified");
        double newSurfaceArea = calculator.calculateSurfaceArea(tetrahedron);
        double newVolume = calculator.calculateVolume(tetrahedron);
        Parameters newParameters = new Parameters(newSurfaceArea, newVolume);
        parameterRegistrar.put(tetrahedron.getId(), newParameters);
        LOGGER.debug("Parameters of tetrahedron in Registrar (Singleton) was changed");
    }

}
