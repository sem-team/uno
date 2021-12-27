package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.exceptions.MessageManagerException;
import ru.kpfu.itis.sem_team.listeners.IServerMessageListener;
import ru.kpfu.itis.sem_team.server.IServer;
import ru.kpfu.itis.sem_team.server.UnoServer;

public abstract class UnoServerMessageListener implements IServerMessageListener {
    protected UnoServer server;
    protected final Integer TYPE = 0;
    protected final String ACTION = "none";

    @Override
    public void init(IServer server) {
        if (!server.getClass().equals(UnoServer.class)) {
            throw new MessageManagerException("Unable to register app: incorrect class");
        }
        this.server = (UnoServer) server;
    }

    public boolean isMessageTypeAcceptable(Integer providedType, Integer intendedType) {
        return providedType != null && providedType.equals(intendedType);
    }

    @Override
    public int getType() {
        return TYPE;
    }

    @Override
    public String getAction() {
        return ACTION;
    }
}
