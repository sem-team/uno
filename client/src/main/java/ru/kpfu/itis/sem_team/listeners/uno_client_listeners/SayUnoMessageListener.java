package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.entities.exceptions.UnoException;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class SayUnoMessageListener extends AbstractUnoClientListener {

    public static final int TYPE = UnoProtocol.MESSAGE_PLAYER;
    public static final String ACTION = "uno";

    @Override
    public void handle(IMessage message) {
        UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);
        UnoPlayer player = (UnoPlayer) client.getUnoApp().getMenu().getPlayer(messagePlayer);
        Boolean isValid = (Boolean) message.getParameter("valid");

        if (isValid) {
            try {
                player.sayUno();
            } catch (UnoException e) {
                e.printStackTrace();
            }
        }
    }
}
