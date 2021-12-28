package ru.kpfu.itis.sem_team.message_managers;

import ru.kpfu.itis.sem_team.listeners.IServerMessageListener;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.server.IServer;

import java.util.LinkedList;
import java.util.List;

public class ServerMessageManager implements IServerMessageManager {
    private final List<IServerMessageListener> listeners;
    private IServer server;

    public ServerMessageManager() {
        listeners = new LinkedList<>();
    }

    @Override
    public void addMessageListener(IServerMessageListener eventListener) {
        eventListener.init(server);
        listeners.add(eventListener);
    }

    @Override
    public void handle(int connectionId, IMessage message) {
        System.out.println(message);

        Integer type = (Integer) message.getParameter("type");
        String action = (String) message.getParameter("action");

        listeners.forEach(listener -> {
                if (listener.getType().equals(type) && listener.getAction().equals(action))
                    listener.handle(connectionId, message);
        });
    }

    @Override
    public void register(IServer server) {
        this.server = server;
        server.setMessageManager(this);
    }
}
