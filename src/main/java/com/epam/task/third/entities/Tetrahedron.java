package com.epam.task.third.entities;

import java.util.Objects;

public class Tetrahedron {

    double ribLength;
    // points of the tetrahedron on the coordinate plane
    Point pointA;
    Point pointB;
    Point pointC;

    public Tetrahedron(double ribLength, Point pointA, Point pointB, Point pointC) {
        this.ribLength = ribLength;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public double getRibLength() {
        return ribLength;
    }

    public void setRibLength(double ribLength) {
        this.ribLength = ribLength;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Tetrahedron that = (Tetrahedron) o;
        return Double.compare(that.ribLength, ribLength) == 0 &&
                Objects.equals(pointA, that.pointA) &&
                Objects.equals(pointB, that.pointB) &&
                Objects.equals(pointC, that.pointC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ribLength, pointA, pointB, pointC);
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "ribLength=" + ribLength +
                ", pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                '}';
    }
}
