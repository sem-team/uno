package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class AddPlayerMessageListener extends AbstractUnoClientListener {

    public static final int TYPE = UnoProtocol.MESSAGE_PLAYER;
    public static final String ACTION = "create";

    @Override
    public void handle(IMessage message) {
        Boolean isValid = (Boolean) message.getParameter("valid");
        //TODO:
        if (isValid) {
            UnoPlayer player = message.getParameter(UnoPlayer.class);
            client.getUnoApp().getMenu().addPlayer(player);
        }
    }
}
