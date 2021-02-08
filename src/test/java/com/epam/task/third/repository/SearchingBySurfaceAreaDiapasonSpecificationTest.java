package com.epam.task.third.repository;

import com.epam.task.third.entities.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;

public class SearchingBySurfaceAreaDiapasonSpecificationTest {

    private SearchingBySurfaceAreaDiapasonSpecification searchingByDiapason = new SearchingBySurfaceAreaDiapasonSpecification(100, 200);
    private Tetrahedron conformingTetrahedron = new Tetrahedron(10.0);
    private Tetrahedron nonConformingTetrahedron = new Tetrahedron(1000.0);

    @Test
    public void isConformsToShouldReturnTrue() {
        boolean actualResult = searchingByDiapason.isConformsTo(conformingTetrahedron);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void isConformsToShouldReturnFalse() {
        boolean actualResult = searchingByDiapason.isConformsTo(nonConformingTetrahedron);
        Assert.assertFalse(actualResult);
    }
}
