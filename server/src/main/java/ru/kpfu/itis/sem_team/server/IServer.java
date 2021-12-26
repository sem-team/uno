package ru.kpfu.itis.sem_team.server;

import ru.kpfu.itis.sem_team.event_manager.IServerMessageManager;
import ru.kpfu.itis.sem_team.message.IMessage;

public interface IServer {
    void init();
    void listen();
    IServerMessageManager getMessageManager();
    void setMessageManager(IServerMessageManager manager);
    void sendMessage(int connectionId, IMessage message);
    void sendMessageBroadcast(IMessage message);
}
