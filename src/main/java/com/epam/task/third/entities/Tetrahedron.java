package com.epam.task.third.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tetrahedron {

    double ribLength;

    List<Point> pointsOnPlane = new ArrayList<>();

    public Tetrahedron(double ribLength, List<Point> pointsOnPlane) {
        this.ribLength = ribLength;
        this.pointsOnPlane = pointsOnPlane;
    }

    public double getRibLength() {
        return ribLength;
    }

    public void setRibLength(double ribLength) {
        this.ribLength = ribLength;
    }

    public List<Point> getPointsOnPlane() {
        return pointsOnPlane;
    }

    public void setPointsOnPlane(List<Point> pointsOnPlane) {
        this.pointsOnPlane = pointsOnPlane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
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
