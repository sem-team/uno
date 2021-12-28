package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class AddPlayerMessageListener extends AbstractUnoClientMessageListener {

    @Override
    public void handle(IMessage message) {
        UnoPlayer player = (UnoPlayer) message.getParameter("player");
        client.getModel().setCurrentPlayer(player);
    }

    @Override
    public Integer getType() {
        return UnoProtocol.MESSAGE_PLAYER;
    }

    @Override
    public String getAction() {
        return "create";
    }
}
