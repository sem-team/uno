package ru.kpfu.itis.sem_team.event_listeners.uno_listeners.client_uno_event_listeners;

import ru.kpfu.itis.sem_team.app.GuiUno;
import ru.kpfu.itis.sem_team.app.IApp;
import ru.kpfu.itis.sem_team.event_listeners.IEventListener;
import ru.kpfu.itis.sem_team.exceptions.EventListenerException;

public abstract class AbstractClientUnoEventListener implements IEventListener {
    protected GuiUno uno;

    @Override
    public void init(IApp app) {
        if (!app.getClass().equals(GuiUno.class)) {
            throw new EventListenerException("Unable to register app: incorrect class");
        }
        this.uno = (GuiUno) app;
    }
}
