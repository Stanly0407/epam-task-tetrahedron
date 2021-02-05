package com.epam.task.third.service;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TetrahedronSortingTest {

    private TetrahedronSorting tetrahedronSorting = new TetrahedronSorting();
    private List<Tetrahedron> tetrahedrons = new ArrayList<>();
    private TreeSet<Tetrahedron> expectedSortedTetrahedrons = new TreeSet<>();


    @Before
    public void createListTetrahedrons() {
        Point firstPointA = new Point(2.0, 3.8);
        Point secondPointA = new Point(3.0, 7.8);
        Point thirdPointA = new Point(4.0, 9.8);
        Tetrahedron tetrahedronFirst = new Tetrahedron(1001, 10, firstPointA);
        Tetrahedron tetrahedronSecond = new Tetrahedron(1002, 20, secondPointA);
        Tetrahedron tetrahedronThird = new Tetrahedron(1003, 30, thirdPointA);
        tetrahedrons.add(tetrahedronThird);
        tetrahedrons.add(tetrahedronFirst);
        tetrahedrons.add(tetrahedronSecond);
        expectedSortedTetrahedrons.add(tetrahedronSecond);
        expectedSortedTetrahedrons.add(tetrahedronFirst);
        expectedSortedTetrahedrons.add(tetrahedronThird);
    }

    @Test
    public void shouldGetTetrahedronsSortedByRibLength() {
        TreeSet<Tetrahedron> actualTetrahedron = tetrahedronSorting.getTetrahedronsSortedByRibLength(tetrahedrons);
        Assert.assertEquals(expectedSortedTetrahedrons, actualTetrahedron);
    }

}
