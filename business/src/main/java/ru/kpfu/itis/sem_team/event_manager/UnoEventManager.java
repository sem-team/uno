package ru.kpfu.itis.sem_team.event_manager;

import ru.kpfu.itis.sem_team.app.IApp;
import ru.kpfu.itis.sem_team.app.Uno;
import ru.kpfu.itis.sem_team.event.Event;
import ru.kpfu.itis.sem_team.event_listeners.IEventListener;
import ru.kpfu.itis.sem_team.exceptions.EventManagerException;

import java.util.List;

public class UnoEventManager implements IEventManager {
    private List<IEventListener> listeners;
    private Uno uno;

    @Override
    public void addEventListener(IEventListener listener) {
        listeners.add(listener);
        listener.init(uno);
    }

    @Override
    public void register(IApp app) {
        if (!app.getClass().equals(Uno.class)) {
            throw new EventManagerException("Unable to register app: incorrect class");
        }
        this.uno = (Uno) app;
    }

    @Override
    public void handle(Event event) {
        listeners.forEach(listener -> listener.handle(event));
    }
}