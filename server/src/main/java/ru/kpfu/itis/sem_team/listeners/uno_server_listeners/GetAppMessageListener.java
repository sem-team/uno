package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class GetAppMessageListener extends UnoServerMessageListener {
    public static final int TYPE = UnoProtocol.MESSAGE_APP;
    public static final String ACTION = "get";

    @Override
    public void handle(int connectionId, IMessage message) {
        server.sendMessage(connectionId, message);
        //send message from log to be up-to-date with current app state;
        server.getLogger().getLogs().forEach(loggedMessage -> server.sendMessage(connectionId, loggedMessage));
    }
}
