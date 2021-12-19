package ru.kpfu.itis.sem_team.server;

import ru.kpfu.itis.sem_team.listeners.IServerEventListener;
import ru.kpfu.itis.sem_team.message.Message;

public interface IServer {
    void init();
    void listen();
    void addEventListener(IServerEventListener eventListener);
    void sendMessage(int connectionId, Message message);
}
