package com.epam.task.third.service;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronServiceTest {
    private static final double DELTA = 0.01;
    private TetrahedronService tetrahedronService = new TetrahedronService();
    private Tetrahedron testedTetrahedron = new Tetrahedron();

    @Before
    public void createTested() {
        List<Point> points = new ArrayList<>();
        double ribLength = 8.0;
        Point pointA = new Point(2.0, 2.0);
        points.add(pointA);
        Point pointB = new Point(8.0, 2.0);
        points.add(pointB);
        Point pointC = new Point(5.0, 7.2);
        points.add(pointC);
        testedTetrahedron.setRibLength(ribLength);
        testedTetrahedron.setPointsOnPlane(points);
    }

    @Test
    public void calculateSurfaceAreaTest() {
        double expectedArea = 110.8512;
        double actualArea = tetrahedronService.calculateSurfaceArea(testedTetrahedron);
        Assert.assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void calculateFigureVolumeTest() {
        double expectedVolume = 60.3397;
        double actualVolume = tetrahedronService.calculateFigureVolume(testedTetrahedron);
        Assert.assertEquals(expectedVolume, actualVolume, DELTA);
    }

    @Test
    public void compareVolumesAfterSectionTest() {
        double expectedResult = 0.4218; //25.4558
        double actualResult = tetrahedronService.compareVolumesAfterSection(testedTetrahedron);
        Assert.assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test
    public void isFigureDefinedShapeShouldReturnTrue() {
        boolean actualResult = tetrahedronService.isFigureDefinedShape(testedTetrahedron);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void isFigureDefinedShapeShouldReturnFalse() {
        List<Point> points = new ArrayList<>();
        double ribLength = 7.0;
        Point pointA = new Point(1.2, 2.0);
        points.add(pointA);
        Point pointB = new Point(9.0, 2.0);
        points.add(pointB);
        Point pointC = new Point(5.0, 8.93);
        points.add(pointC);
        Tetrahedron notTetrahedron = new Tetrahedron(ribLength, points);
        boolean actualResult = tetrahedronService.isFigureDefinedShape(notTetrahedron);
        Assert.assertFalse(actualResult);
    }

    @Test
    public void isFigureBaseOnCoordinatePlaneReturnTrue() {
        List<Point> points = new ArrayList<>();
        double ribLength = 8.0;
        Point pointA = new Point(1.0, 2.0);
        points.add(pointA);
        Point pointB = new Point(9.0, 2.0);
        points.add(pointB);
        Point pointC = new Point(5.0, 8.93);
        points.add(pointC);
        Tetrahedron tetrahedronOnPlane = new Tetrahedron(ribLength, points);
        boolean actualResult = tetrahedronService.isFigureBaseOnCoordinatePlane(tetrahedronOnPlane);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void isFigureBaseOnCoordinatePlaneReturnFalse() {
        boolean actualResult = tetrahedronService.isFigureBaseOnCoordinatePlane(testedTetrahedron);
        Assert.assertFalse(actualResult);
            }



}
