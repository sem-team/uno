package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.exceptions.MessageManagerException;
import ru.kpfu.itis.sem_team.listeners.IServerMessageListener;
import ru.kpfu.itis.sem_team.server.IServer;
import ru.kpfu.itis.sem_team.server.UnoServer;

public abstract class UnoServerMessageListener implements IServerMessageListener {
    protected UnoServer server;

    @Override
    public void init(IServer server) {
        if (!server.getClass().equals(UnoServer.class)) {
            throw new MessageManagerException("Unable to register app: incorrect class");
        }
        this.server = (UnoServer) server;
    }
}
