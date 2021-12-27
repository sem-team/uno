package ru.kpfu.itis.sem_team.listeners;

import ru.kpfu.itis.sem_team.client.IClient;
import ru.kpfu.itis.sem_team.client.UnoClient;
import ru.kpfu.itis.sem_team.exceptions.ClientMessageListenerException;
import ru.kpfu.itis.sem_team.message.IMessage;

import static ru.kpfu.itis.sem_team.event.Event.from;

public class UnoClientMessageListener implements IClientMessageListener {
    private UnoClient client;

    @Override
    public void init(IClient client) {
        if (!client.getClass().equals(UnoClient.class)) {
            throw new ClientMessageListenerException("Unable to register client: incorrect class");
        }
    }

    @Override
    public void handle(IMessage message) {
        client.getApp().getManager().handle(from(message));
    }
}
