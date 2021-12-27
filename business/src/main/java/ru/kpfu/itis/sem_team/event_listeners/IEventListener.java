package ru.kpfu.itis.sem_team.event_listeners;

import ru.kpfu.itis.sem_team.app.IApp;
import ru.kpfu.itis.sem_team.event.IEvent;

public interface IEventListener {
    void init(IApp app);
    void handle(IEvent event);
}
