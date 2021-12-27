package ru.kpfu.itis.sem_team.listeners;

import ru.kpfu.itis.sem_team.client.IClient;
import ru.kpfu.itis.sem_team.message.IMessage;

public interface IClientMessageListener {
    void init(IClient client);
    void handle(IMessage message);
    Integer getType();
    String getAction();
}
