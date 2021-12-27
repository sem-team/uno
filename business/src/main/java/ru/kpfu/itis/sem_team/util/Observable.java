package ru.kpfu.itis.sem_team.util;

import ru.kpfu.itis.sem_team.event.IEvent;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(IEvent event) {
        observers.forEach(observer -> observer.update(this, event));
    }

}
