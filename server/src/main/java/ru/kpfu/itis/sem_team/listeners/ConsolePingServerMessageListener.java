package ru.kpfu.itis.sem_team.listeners;

import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.message.Message;
import ru.kpfu.itis.sem_team.server.IServer;

public class ConsolePingServerMessageListener implements IServerMessageListener {
    private IServer server;

    public ConsolePingServerMessageListener() {
    }

    @Override
    public void init(IServer server) {
        this.server = server;
    }

    @Override
    public void handle(int connectionId, IMessage message) {
        String type = message.getParameter(String.class);
        if (type.equals("ping")) {
            System.out.println("Got ping from connection " + connectionId);
        }

        IMessage responseMessage = new Message();
        responseMessage.addParameter("type", "pong");
        server.sendMessage(connectionId, responseMessage);
    }
}
