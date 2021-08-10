package com.epam.task.third.repository;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;


public class SearchingByFirstQuadrantSpecificationTest {

    private SearchingByFirstQuadrantSpecification searching = new SearchingByFirstQuadrantSpecification();

    @Test
    public void isConformsToShouldReturnTrue() {
        Point firstPointA = new Point(1.0, 1.0);
        Point firstPointB = new Point(2.0, 2.0);
        Point firstPointC = new Point(3.0, 3.0);
        Tetrahedron conformedTetrahedron = new Tetrahedron(1, 1, firstPointA, firstPointB, firstPointC);
        boolean actualResult = searching.isConformsTo(conformedTetrahedron);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void isConformsToShouldReturnFalse() {
        Point secondPointA = new Point(-1.0, -1.0);
        Point secondPointB = new Point(-2.0, -2.0);
        Point secondPointC = new Point(-3.0, -3.0);
        Tetrahedron nonConformedTetrahedron = new Tetrahedron(1, 1, secondPointA, secondPointB, secondPointC);
        boolean actualResult = searching.isConformsTo(nonConformedTetrahedron);
        Assert.assertFalse(actualResult);
    }

}
