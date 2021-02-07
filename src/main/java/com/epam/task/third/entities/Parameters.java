package com.epam.task.third.entities;

public class Parameters {
    private double surfaceArea;
    private double volume;

    public Parameters(double surfaceArea, double volume) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "surfaceArea=" + surfaceArea +
                ", volume=" + volume +
                '}';
    }
}
