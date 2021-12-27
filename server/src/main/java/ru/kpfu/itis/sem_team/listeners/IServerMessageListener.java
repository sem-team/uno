package ru.kpfu.itis.sem_team.listeners;

import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.server.IServer;

public interface IServerMessageListener {
    /**
     * Connects listener to selected server. Invoking it manually is unnecessary
     * as listener should be initialized when added to server.
     */
    void init(IServer server);
    void handle(int connectionId, IMessage message);
}
