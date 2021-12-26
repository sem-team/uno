package ru.kpfu.itis.sem_team.message_manager;

import ru.kpfu.itis.sem_team.client.IClient;
import ru.kpfu.itis.sem_team.listeners.IClientMessageListener;
import ru.kpfu.itis.sem_team.message.IMessage;

import java.util.LinkedList;
import java.util.List;

public class ClientMessageManager implements IClientMessageManager {
    private final List<IClientMessageListener> listeners;
    private IClient client;

    public ClientMessageManager() {
        listeners = new LinkedList<>();
    }

    @Override
    public void addMessageListener(IClientMessageListener listener) {
        listeners.add(listener);
        listener.init(client);
    }

    @Override
    public void register(IClient client) {
        this.client = client;
    }

    @Override
    public void handle(IMessage message) {
        listeners.forEach(listener -> listener.handle(message));
    }
}
