package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class AddPlayerMessageListener extends UnoServerMessageListener {

    public static final int TYPE = 1;
    public static final String ACTION = "create";

    @Override
    public void handle(int connectionId, IMessage message) {
        Integer type = (Integer) message.getParameter("type");
        if (isMessageTypeAcceptable(type, UnoProtocol.MESSAGE_PLAYER)) {
            UnoPlayer player = new UnoPlayer(connectionId);
            message.addParameter("player", player);
            server.sendMessage(connectionId, message);
        }
    }
}
