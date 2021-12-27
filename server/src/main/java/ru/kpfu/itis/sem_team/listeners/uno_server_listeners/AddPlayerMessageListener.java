package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class AddPlayerMessageListener extends UnoServerMessageListener{
    @Override
    public void handle(int connectionId, IMessage message) {
        Integer type = (Integer) message.getParameter("type");
        if (type == null || type == UnoProtocol.MESSAGE_PLAYER) {
            return;
        }

        UnoPlayer player = message.getParameter(UnoPlayer.class);
        if (server.getUnoApp().getMenu().isPlayerValid(player)) {
            server.getUnoApp().getMenu().addPlayer(player);
            message.addParameter("valid", true);
            server.sendMessageBroadcast(message);
        } else {
            message.addParameter("valid", false);
            server.sendMessage(connectionId, message);
        }
    }
}