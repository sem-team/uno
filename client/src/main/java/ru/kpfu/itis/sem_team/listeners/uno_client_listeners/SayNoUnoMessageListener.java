package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.entities.exceptions.UnoException;
import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class SayNoUnoMessageListener extends AbstractUnoClientListener {

    public static final int TYPE = UnoProtocol.MESSAGE_PLAYER;
    public static final String ACTION = "noUno";

    @Override
    public void handle(IMessage message) {
        UnoPlayer messageSourcePlayer = (UnoPlayer) message.getParameter("sourcePlayer");
        UnoPlayer messageDestinationPlayer = (UnoPlayer) message.getParameter("destinationPlayer");
        Boolean isValid = (Boolean) message.getParameter("valid");

        UnoPlayer sourcePlayer = (UnoPlayer) client.getUnoApp().getMenu().getPlayer(messageSourcePlayer);
        UnoPlayer destinationPlayer = (UnoPlayer) client.getUnoApp().getMenu().getPlayer(messageDestinationPlayer);
        UnoRoom room = (UnoRoom) client.getUnoApp().getMenu().getRoomByPlayer(sourcePlayer);

        if (isValid) {
            try {
                sourcePlayer.sayNotUno(destinationPlayer, (UnoGame) room.getGame());
            } catch (UnoException e) {
                e.printStackTrace();
            }
        }
    }
}
