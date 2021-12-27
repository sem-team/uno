package ru.kpfu.itis.sem_team.listeners;

import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.message.Message;
import ru.kpfu.itis.sem_team.server.IServer;

public class ConsolePingServerMessageListener implements IServerMessageListener {
    private IServer server;
    public final Integer TYPE = 0;
    public final String ACTION = "ping";

    public ConsolePingServerMessageListener() {
    }

    @Override
    public void init(IServer server) {
        this.server = server;
    }

    @Override
    public void handle(int connectionId, IMessage message) {
        IMessage responseMessage = new Message();
        responseMessage.addParameter("type", TYPE);
        responseMessage.addParameter("action", ACTION);

        server.sendMessage(connectionId, responseMessage);
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
