package com.epam.task.third.entities;

import java.util.Objects;

public class Tetrahedron implements Comparable<Tetrahedron> {

    private int id;
    private double ribLength;
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Tetrahedron(double ribLength, Point pointA, Point pointB, Point pointC) {
        this.ribLength = ribLength;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Tetrahedron() {
    }

    public Tetrahedron(double ribLength) {
        this.ribLength = ribLength;
    }

    public Tetrahedron(int id) {
        this.id = id;
    }

    public Tetrahedron(int id, double ribLength) {
        this.id = id;
        this.ribLength = ribLength;
    }

    public Tetrahedron(int id, double ribLength, Point pointA, Point pointB, Point pointC) {
        this.id = id;
        this.ribLength = ribLength;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Tetrahedron(int id, double ribLength, Point pointA) {
        this.id = id;
        this.ribLength = ribLength;
        this.pointA = pointA;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return id == that.id &&
                Double.compare(that.ribLength, ribLength) == 0 &&
                Objects.equals(pointA, that.pointA) &&
                Objects.equals(pointB, that.pointB) &&
                Objects.equals(pointC, that.pointC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ribLength, pointA, pointB, pointC);
    }

    @Override
    public int compareTo(Tetrahedron tetrahedron) {
        if (this.ribLength < tetrahedron.ribLength) {
            return -1;
        } else if (tetrahedron.ribLength < this.ribLength) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "id=" + id +
                ", ribLength=" + ribLength +
                ", pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                '}';
    }
}
