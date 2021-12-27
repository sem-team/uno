package ru.kpfu.itis.sem_team.event_manager;

import ru.kpfu.itis.sem_team.app.IApp;
import ru.kpfu.itis.sem_team.event.Event;
import ru.kpfu.itis.sem_team.event_listeners.IEventListener;

public interface IEventManager {
    void addEventListener(IEventListener listener);
    void register(IApp app);
    void handle(Event event);
}
