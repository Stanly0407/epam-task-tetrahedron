package com.epam.task.third.entities;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronObservable extends Tetrahedron {

    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

//    public void setNews(String news) {
//        this.news = news;
//        for (Channel channel : this.channels) {
//            channel.update(this.news);
//        }
//    }

}
