package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.client.IClient;
import ru.kpfu.itis.sem_team.client.UnoClient;
import ru.kpfu.itis.sem_team.exceptions.ClientMessageListenerException;
import ru.kpfu.itis.sem_team.listeners.IClientMessageListener;

public abstract class AbstractUnoClientMessageListener implements IClientMessageListener {
    protected UnoClient client;
    public static final Integer TYPE = 0;
    public static final String ACTION = "none";

    @Override
    public void init(IClient client) {
        if (!client.getClass().equals(UnoClient.class)) {
            throw new ClientMessageListenerException("Unable to register client: incorrect class");
        }
        this.client = (UnoClient) client;
    }

    @Override
    public Integer getType() {
        return TYPE;
    }

    @Override
    public String getAction() {
        return ACTION;
    }
}
