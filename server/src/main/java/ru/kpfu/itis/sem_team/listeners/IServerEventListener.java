package ru.kpfu.itis.sem_team.listeners;

import ru.kpfu.itis.sem_team.message.Message;
import ru.kpfu.itis.sem_team.server.IServer;

public interface IServerEventListener {
    /**
     * Connects listener to selected server. Invoking it manually is unnecessary
     * as listener should be initialized when added to server.
     */
    void init(IServer server);
    void handle(int connectionId, Message message);
}
