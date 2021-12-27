package ru.kpfu.itis.sem_team.util;

import ru.kpfu.itis.sem_team.event.IEvent;

public interface Observer {

    void update(Observable o, IEvent event);

}
