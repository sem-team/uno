package ru.kpfu.itis.sem_team.event_manager;

import ru.kpfu.itis.sem_team.listeners.IServerMessageListener;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.server.IServer;

public interface IServerMessageManager {
    void addMessageListener(IServerMessageListener eventListener);
    void handle(int connectionId, IMessage message);
    void register(IServer server);
}
