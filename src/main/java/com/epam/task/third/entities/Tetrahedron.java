package com.epam.task.third.entities;

import java.util.List;
import java.util.Objects;

public class Tetrahedron {

    private double ribLength;
    private List<Point> pointsOnPlane;

    public Tetrahedron(double ribLength) {
        this.ribLength = ribLength;
    }

    public Tetrahedron(double ribLength, List<Point> pointsOnPlane) {
        this.pointsOnPlane = pointsOnPlane;
        this.ribLength = ribLength;
    }

    public Tetrahedron() {

    }

    public double getRibLength() {
        return ribLength;
    }

    public List<Point> getPointsOnPlane() {
        return pointsOnPlane;
    }

    public void setRibLength(double ribLength) {
        this.ribLength = ribLength;
    }

    public void setPointsOnPlane(List<Point> pointsOnPlane) {
        this.pointsOnPlane = pointsOnPlane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tetrahedron that = (Tetrahedron) o;
        return Double.compare(that.ribLength, ribLength) == 0 &&
                Objects.equals(pointsOnPlane, that.pointsOnPlane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ribLength, pointsOnPlane);
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "ribLength=" + ribLength +
                ", pointsOnPlane=" + pointsOnPlane +
                '}';
    }
}
