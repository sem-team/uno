package ru.kpfu.itis.sem_team.event_listeners.uno_listeners;

import ru.kpfu.itis.sem_team.app.IApp;
import ru.kpfu.itis.sem_team.app.Uno;
import ru.kpfu.itis.sem_team.event_listeners.IEventListener;
import ru.kpfu.itis.sem_team.exceptions.EventListenerException;

public abstract class AbstractUnoEventListener implements IEventListener {
    protected Uno uno;

    @Override
    public void init(IApp app) {
        if (!app.getClass().equals(Uno.class)) {
            throw new EventListenerException("Unable to register app: incorrect class");
        }
        this.uno = (Uno) app;
    }
}
