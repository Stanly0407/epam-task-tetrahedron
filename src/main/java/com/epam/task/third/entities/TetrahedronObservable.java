package com.epam.task.third.entities;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronObservable extends Tetrahedron implements Observable {

    private static final Logger LOGGER = Logger.getLogger(TetrahedronObservable.class);

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
            observer.updateParameters(this);
        }
        LOGGER.debug("All observers notified about changing Tetrahedron");
    }
}
