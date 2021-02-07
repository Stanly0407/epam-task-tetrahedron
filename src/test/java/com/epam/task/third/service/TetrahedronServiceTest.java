package com.epam.task.third.service;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;


public class TetrahedronServiceTest {
    private static final double DELTA = 0.01;
    private TetrahedronService tetrahedronService = new TetrahedronService();

    private Point pointA = new Point(2.0, 2.0);
    private Point pointB = new Point(8.0, 2.0);
    private Tetrahedron testedTetrahedron = new Tetrahedron(8.0, pointA, pointB, new Point(5.0, 7.2));

    @Test
    public void shouldCalculateSurfaceAreaTest() {
        double expectedArea = 110.8512;
        double actualArea = tetrahedronService.calculateSurfaceArea(testedTetrahedron);
        Assert.assertEquals(expectedArea, actualArea, DELTA);
    }

    @Test
    public void shouldCalculateVolumeTest() {
        double expectedVolume = 60.3397;
        double actualVolume = tetrahedronService.calculateVolume(testedTetrahedron);
        Assert.assertEquals(expectedVolume, actualVolume, DELTA);
    }

    @Test
    public void shouldCompareVolumesTest() {
        double expectedResult = 0.4218;
        double actualResult = tetrahedronService.proportionPartVolumes(testedTetrahedron);
        Assert.assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test
    public void isFigureTetrahedronShouldReturnTrue() {
        boolean actualResult = tetrahedronService.isFigureTetrahedron(testedTetrahedron);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void isFigureTetrahedronShouldReturnFalse() {
        double ribLength = 7.0;
        Point pointA = new Point(1.2, 2.0);
        Point pointB = new Point(9.0, 2.0);
        Point pointC = new Point(5.0, 8.93);
        Tetrahedron notTetrahedron = new Tetrahedron(ribLength, pointA, pointB, pointC);
        boolean actualResult = tetrahedronService.isFigureTetrahedron(notTetrahedron);
        Assert.assertFalse(actualResult);
    }

    @Test
    public void isFigureBaseOnCoordinatePlaneReturnTrue() {
        double ribLength = 8.0;
        Point pointA = new Point(1.0, 2.0);
        Point pointB = new Point(9.0, 2.0);
        Point pointC = new Point(5.0, 8.93);
        Tetrahedron tetrahedronOnPlane = new Tetrahedron(ribLength, pointA, pointB, pointC);
        boolean actualResult = tetrahedronService.isFigureBaseOnCoordinatePlane(tetrahedronOnPlane);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void isFigureBaseOnCoordinatePlaneReturnFalse() {
        boolean actualResult = tetrahedronService.isFigureBaseOnCoordinatePlane(testedTetrahedron);
        Assert.assertFalse(actualResult);
    }

    @Test
    public void shouldGetDistanceBetweenTwoPoints() {
        double expectedDistance = 6.0;
        double actualDistance = tetrahedronService.getDistanceBetweenTwoPoints(pointA, pointB);
        Assert.assertEquals(expectedDistance, actualDistance, DELTA);
    }

    @Test
    public void shouldGetDistanceBetweenTwoPointsBasedOnFigure() {
        double expectedDistance = 6.0;
        double actualDistance = tetrahedronService.getDistanceBetweenTwoPoints(testedTetrahedron);
        Assert.assertEquals(expectedDistance, actualDistance, DELTA);
    }
}
