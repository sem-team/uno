package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class GetAppMessageListener extends UnoServerMessageListener {

    @Override
    public void handle(int connectionId, IMessage message) {
        server.sendMessage(connectionId, message);

        // send message from log to be up-to-date with current app state;
        for (IMessage log : server.getLogger().getLogs()) {
            server.sendMessage(connectionId, log);
        }
    }

    @Override
    public Integer getType() {
        return UnoProtocol.MESSAGE_APP;
    }

    @Override
    public String getAction() {
        return "get";
    }
}
