package ru.kpfu.itis.sem_team.services;

import ru.kpfu.itis.sem_team.message.IMessage;

public interface IMessageService {
    void sendMessage(IMessage message);
}
