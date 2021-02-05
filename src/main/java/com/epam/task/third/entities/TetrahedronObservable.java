package com.epam.task.third.entities;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronObservable extends Tetrahedron implements Observable {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {this.observers.add(observer);}

    public void removeObserver(Observer observer) {this.observers.remove(observer);}

    @Override
    public void setRibLength(double ribLength){
        super.setRibLength(ribLength);
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers){
            observer.update(this);
        }
    }
}
