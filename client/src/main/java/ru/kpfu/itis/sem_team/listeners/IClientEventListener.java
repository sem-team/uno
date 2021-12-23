package ru.kpfu.itis.sem_team.listeners;

import ru.kpfu.itis.sem_team.client.IClient;
import ru.kpfu.itis.sem_team.message.IMessage;

public interface IClientEventListener {
    void init(IClient client);
    void handle(IMessage message);
}
