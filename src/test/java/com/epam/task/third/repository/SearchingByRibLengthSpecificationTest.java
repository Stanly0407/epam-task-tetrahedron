package com.epam.task.third.repository;

import com.epam.task.third.entities.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;

public class SearchingByRibLengthSpecificationTest {

    private final static double CONFORMING_RIB_LENGTH = 10.0;
    private final static double NONCONFORMING_RIB_LENGTH = 20.0;
    private SearchingByRibLengthSpecification searchingByRibLength = new SearchingByRibLengthSpecification(CONFORMING_RIB_LENGTH);
    private SearchingByRibLengthSpecification searchingByNonconformingRibLength  = new SearchingByRibLengthSpecification(NONCONFORMING_RIB_LENGTH);
    private Tetrahedron testedTetrahedron = new Tetrahedron(CONFORMING_RIB_LENGTH);

    @Test
    public void isConformsToShouldReturnTrue(){
        boolean actualResult  = searchingByRibLength.isConformsTo(testedTetrahedron);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void isConformsToShouldReturnFalse(){
        boolean actualResult  = searchingByNonconformingRibLength.isConformsTo(testedTetrahedron);
        Assert.assertFalse(actualResult);
    }
}
