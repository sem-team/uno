package ru.kpfu.itis.sem_team.message_manager;

import ru.kpfu.itis.sem_team.client.IClient;
import ru.kpfu.itis.sem_team.listeners.IClientMessageListener;
import ru.kpfu.itis.sem_team.message.IMessage;

public interface IClientMessageManager {
    void addMessageListener(IClientMessageListener listener);
    void register(IClient client);
    void handle(IMessage message);
}
