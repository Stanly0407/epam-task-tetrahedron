package com.epam.task.third.repository;

import com.epam.task.third.entities.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;

public class SearchingBySurfaceAreaDiapasonSpecificationTest {

    private SearchingBySurfaceAreaDiapasonSpecification searchingByDiapason = new SearchingBySurfaceAreaDiapasonSpecification(100, 200);

    @Test
    public void isConformsToShouldReturnTrue() {
        Tetrahedron conformingTetrahedron = new Tetrahedron(10.0);
        boolean actualResult = searchingByDiapason.isConformsTo(conformingTetrahedron);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void isConformsToShouldReturnFalse() {
        Tetrahedron nonConformingTetrahedron = new Tetrahedron(1000.0);
        boolean actualResult = searchingByDiapason.isConformsTo(nonConformingTetrahedron);
        Assert.assertFalse(actualResult);
    }
}
