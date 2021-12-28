package ru.kpfu.itis.sem_team.util;

import ru.kpfu.itis.sem_team.event.IEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Observable {
    private final List<Observer> observers = new CopyOnWriteArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(IEvent event) {
        observers.forEach(observer -> observer.update(this, event));
    }

}
