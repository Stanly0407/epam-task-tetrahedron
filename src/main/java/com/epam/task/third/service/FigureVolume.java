package com.epam.task.third.service;

public class FigureVolume {

    public double calculateFigureVolume(double ribLength) {
        return (1.0 / 12.0) * Math.pow(ribLength, 3) * Math.sqrt(2);
    }
}
