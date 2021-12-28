package ru.kpfu.itis.sem_team.message_manager;

import ru.kpfu.itis.sem_team.client.IClient;
import ru.kpfu.itis.sem_team.listeners.IClientMessageListener;
import ru.kpfu.itis.sem_team.message.IMessage;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
        System.out.println(message);
        Integer type = (Integer) message.getParameter("type");
        String action = (String) message.getParameter("action");
        listeners.forEach(listener -> {
            if (Objects.equals(listener.getType(), type) && listener.getAction().equals(action))
                listener.handle(message);
        });
    }
}
