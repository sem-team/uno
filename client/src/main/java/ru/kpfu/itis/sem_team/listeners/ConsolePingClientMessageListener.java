package ru.kpfu.itis.sem_team.listeners;

import ru.kpfu.itis.sem_team.client.IClient;
import ru.kpfu.itis.sem_team.message.IMessage;

public class ConsolePingClientMessageListener implements IClientMessageListener {
    private IClient client;
    private int number = 0;
    public static final Integer TYPE = 0;
    public static final String ACTION = "ping";


    public ConsolePingClientMessageListener() {
    }

    @Override
    public void init(IClient client) {
        this.client = client;
    }

    @Override
    public void handle(IMessage message) {
        String type = message.getParameter(String.class);
        if (type.equals("pong")) {
            System.out.println("Received pong from server");
        }
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
