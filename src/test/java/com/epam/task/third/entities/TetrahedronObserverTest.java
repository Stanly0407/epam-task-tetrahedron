package com.epam.task.third.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TetrahedronObserverTest {

    private TetrahedronObserver parametersRegistrar = TetrahedronObserver.getRegistrar();
    private Tetrahedron updatedTetrahedron = new Tetrahedron(1001, 10);
    private Map<Integer, Parameters> expectedParametersContent = new HashMap<>();

    @Before
    public void expectedRegistrarContent() {
        Parameters parameters = new Parameters(173.20, 117.85);
        expectedParametersContent.put(updatedTetrahedron.getId(), parameters);
}

    @Test
    public void shouldUpdateParameters() {
        parametersRegistrar.updateParameters(updatedTetrahedron);
        Map<Integer, Parameters> actualContent = new HashMap<>(parametersRegistrar.getParameterRegistrar());

        Assert.assertEquals(expectedParametersContent, actualContent);
    }
}
