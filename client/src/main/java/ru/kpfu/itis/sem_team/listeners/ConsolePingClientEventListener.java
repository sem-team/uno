package ru.kpfu.itis.sem_team.listeners;

import ru.kpfu.itis.sem_team.client.IClient;
import ru.kpfu.itis.sem_team.message.IMessage;

public class ConsolePingClientEventListener implements IClientEventListener {
    private IClient client;
    private int number = 0;

    public ConsolePingClientEventListener() {
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
}
