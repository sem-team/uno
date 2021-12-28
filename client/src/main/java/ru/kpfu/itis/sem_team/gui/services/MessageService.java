package ru.kpfu.itis.sem_team.gui.services;

import ru.kpfu.itis.sem_team.client.IClient;
import ru.kpfu.itis.sem_team.message.IMessage;

public class MessageService implements IMessageService{
    private IClient client;

    public MessageService(IClient client) {
        this.client = client;
    }

    @Override
    public void sendMessage(IMessage message) {
        client.sendMessage(message);
    }
}
