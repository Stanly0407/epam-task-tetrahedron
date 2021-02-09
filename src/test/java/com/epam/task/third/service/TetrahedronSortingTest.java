package com.epam.task.third.service;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class TetrahedronSortingTest {

    private TetrahedronSorting tetrahedronSorting = new TetrahedronSorting();
    private List<Tetrahedron> testedTetrahedrons = new ArrayList<>();
    private List<Tetrahedron> expectedSortedTetrahedrons = new ArrayList<>();

    @Before
    public void createListTetrahedrons() {
        Point firstPointA = new Point(1.0, 1.1);
        Point secondPointA = new Point(2.0, 2.2);
        Point thirdPointA = new Point(3.0, 3.3);
        Tetrahedron tetrahedronFirst = new Tetrahedron(1001, 10, firstPointA);
        Tetrahedron tetrahedronSecond = new Tetrahedron(1002, 20, secondPointA);
        Tetrahedron tetrahedronThird = new Tetrahedron(1003, 30, thirdPointA);
        testedTetrahedrons.add(tetrahedronThird);
        testedTetrahedrons.add(tetrahedronFirst);
        testedTetrahedrons.add(tetrahedronSecond);
        expectedSortedTetrahedrons.add(tetrahedronFirst);
        expectedSortedTetrahedrons.add(tetrahedronSecond);
        expectedSortedTetrahedrons.add(tetrahedronThird);
    }

    @Test
    public void shouldSortById(){
        tetrahedronSorting.sortById(testedTetrahedrons);
        Assert.assertEquals(expectedSortedTetrahedrons, testedTetrahedrons);
    }

    @Test
    public void shouldSortByRibLength() {
        tetrahedronSorting.sortByRibLength(testedTetrahedrons);
        Assert.assertEquals(expectedSortedTetrahedrons, testedTetrahedrons);
    }

    @Test
    public void shouldSortByCoordinateX() {
        tetrahedronSorting.sortByCoordinateX(testedTetrahedrons);
        Assert.assertEquals(expectedSortedTetrahedrons, testedTetrahedrons);
    }

    @Test
    public void shouldSortByCoordinateY() {
        tetrahedronSorting.sortByCoordinateY(testedTetrahedrons);
        Assert.assertEquals(expectedSortedTetrahedrons, testedTetrahedrons);
    }
}
