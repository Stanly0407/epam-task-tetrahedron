package com.epam.task.third.repository;

import com.epam.task.third.entities.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;

public class SearchingByIdSpecificationTest {

    private final static int CONFORMING_ID = 1;
    private final static int NONCONFORMING_ID = 10;
    private SearchingByIdSpecification searchingByExistedId = new SearchingByIdSpecification(CONFORMING_ID);
    private SearchingByIdSpecification searchingByNonexistentId = new SearchingByIdSpecification(NONCONFORMING_ID);
    private Tetrahedron testedTetrahedron = new Tetrahedron(CONFORMING_ID);

    @Test
    public void isConformsToShouldReturnTrue(){
        boolean actualResult  = searchingByExistedId.isConformsTo(testedTetrahedron);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void isConformsToShouldReturnFalse(){
        boolean actualResult  = searchingByNonexistentId.isConformsTo(testedTetrahedron);
        Assert.assertFalse(actualResult);
    }
}
