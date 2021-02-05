package com.epam.task.third.entities;

//Registrator
public class Parameters {

// приватное статическое поле, которое будет содержать одиночный объект
    private static final Parameters PARAMETERS = new Parameters();

    private double surfaceArea;
    private double volume;

    private Parameters() {
    }

    public static Parameters getParameters(){  // метод получения экземпляра класса.
        // Публичный статический метод, кот. будет контролировать жизненный цикл объекта одиночки
        return PARAMETERS;
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
}
