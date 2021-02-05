package com.epam.task.third.entities;

import java.util.HashMap;
import java.util.Map;


public class ParametersRegistrar {

    private Map<Integer, TetrahedronParameters> parametersStore = new HashMap<>();

    private ParametersRegistrar() {
    }

    private static class SingletonHolder {
        private static final ParametersRegistrar REGISTRAR = new ParametersRegistrar();
    }

    public static ParametersRegistrar getRegistrar() {
        return SingletonHolder.REGISTRAR;
    }

    public void updateParameters(Integer id, TetrahedronParameters parameters) {
        parametersStore.put(id, parameters);
    }
}
